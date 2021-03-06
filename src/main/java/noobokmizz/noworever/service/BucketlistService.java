package noobokmizz.noworever.service;

import noobokmizz.noworever.domain.*;
import noobokmizz.noworever.dto.Bucketlist;
import noobokmizz.noworever.dto.LocationData;
import noobokmizz.noworever.dto.LocationResponse;
import noobokmizz.noworever.dto.Location_info;
import noobokmizz.noworever.repository.BucketlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Transactional
@Service
public class BucketlistService {
    private final BucketlistRepository bucketlistRepository;

    public BucketlistService(BucketlistRepository bucketlistRepository){
        this.bucketlistRepository = bucketlistRepository;
    }

    /** 특정 id를 갖는 user 의 bucket list 목록 반환 api **/
    public Bucketlist.BucketlistMultipleContetns show(Bucketlist bucketlistDefaultRequest) {
        // Bkcontents 값 설정
        List<Bkcontents> bkcontentsList = bucketlistRepository.findAllByIdAndBkId(
                bucketlistDefaultRequest.getMem_idnum(), bucketlistDefaultRequest.getBk_id()
        );

        Bucketlist.BucketlistMultipleContetns ret = new Bucketlist.BucketlistMultipleContetns(
                bucketlistDefaultRequest.getMem_idnum(),
                bucketlistDefaultRequest.getBk_id()
        );

        int length = bkcontentsList.size();
        Bucketlist.BucketlistContents bucketlistContents[] = new Bucketlist.BucketlistContents[length];
        for(int i = 0; i < length; i++) {
            bucketlistContents[i] = new Bucketlist.BucketlistContents(
                    bkcontentsList.get(i).getBkcontentsId().getCategory_id(),
                    bkcontentsList.get(i).getCategory(),
                    bkcontentsList.get(i).getBkcontentsId().getLc_id(),
                    bkcontentsList.get(i).getLc_name()
            );
        }
        ret.setBucketlistContentsList(List.of(bucketlistContents));
        return ret;
    }

    /** bucket list 에 새로운 활동을 담는 api **/
    public String put(Bucketlist.BucketlistSingleConetents bucketlistSingleConetents){
        try {
            LocationId locationId = new LocationId(
                    bucketlistSingleConetents.getBucketlistContents().getLc_id(),
                    bucketlistSingleConetents.getBucketlistContents().getCategory_id());

            if(!locationId.getLc_id().startsWith("-")){  // 장소를 선정한 경우
                validateExistLoc(locationId); // 존재하는 {장소, 카테고리} 쌍인지 확인
            }

            validateCategory(bucketlistSingleConetents.getBucketlistContents().getCategory(),
                    bucketlistSingleConetents.getBucketlistContents().getCategory_id());

            BkcontentsId bkcontentsId = new BkcontentsId(
                    bucketlistSingleConetents.getMem_idnum(),
                    bucketlistSingleConetents.getBk_id(),
                    bucketlistSingleConetents.getBucketlistContents().getLc_id(),
                    bucketlistSingleConetents.getBucketlistContents().getCategory_id()
            );
            validateDuplicateAct(bkcontentsId);  // 버킷리스트에 이미 존재하는 활동인지 검증

            bucketlistRepository.save(new Bkcontents(
                    bkcontentsId,
                    bucketlistSingleConetents.getBucketlistContents().getCategory(),
                    bucketlistSingleConetents.getBucketlistContents().getLc_name())
            );

        }catch (Exception e){
            return e.getMessage();
        }
        return "1";
    }
    /** bucket list 내의 활동 삭제 **/
    public String delete(Bucketlist.BucketlistMultipleContetns bucketlistMultipleContetns){
          /** 다중 삭제 **/
//        for(int i = 0; i < bucketlistMultipleContetns.getBucketlistContentsList().size(); i++) {
//            BkcontentsId bkcontentsId = new BkcontentsId();
//            bkcontentsId.setMem_idnum(bucketlistMultipleContetns.getMem_idnum());
//            bkcontentsId.setBk_id(bucketlistMultipleContetns.getBk_id());
//            bkcontentsId.setLc_id(bucketlistMultipleContetns.getBucketlistContentsList().get(i).getLc_id());
//            bkcontentsId.setCategory_id(bucketlistMultipleContetns.getBucketlistContentsList().get(i).getCategory_id());
//
//            // 삭제하고자 하는 데이터가 존재한다면 삭제
//            bucketlistRepository.findByPK(bkcontentsId)
//                    .ifPresent(bkc -> bucketlistRepository.delete(bkc));
//        }
//        return "1";

        /** 단일 삭제 **/
        BkcontentsId bkcontentsId = new BkcontentsId();
        bkcontentsId.setMem_idnum(bucketlistMultipleContetns.getMem_idnum());
        bkcontentsId.setBk_id(bucketlistMultipleContetns.getBk_id());
        bkcontentsId.setLc_id(bucketlistMultipleContetns.getBucketlistContentsList().get(0).getLc_id());
        bkcontentsId.setCategory_id(bucketlistMultipleContetns.getBucketlistContentsList().get(0).getCategory_id());

        AtomicReference<String> status = new AtomicReference<>("0");
        bucketlistRepository.findByPK(bkcontentsId)
                .ifPresent(bkc-> {
                    bucketlistRepository.delete(bkc);
                    status.set("1");
                });
        return status.get();
    }

    /** bucket list 에 있는 활동인지 중복 검증 **/
    private void validateDuplicateAct(BkcontentsId bkcontentsId){
        try {
            bucketlistRepository.findByPK(bkcontentsId)
                    .ifPresent(u -> {
                        throw new IllegalStateException("버킷리스트에 이미 존재하는 활동입니다.");
                    });
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /** 1. location 에 { 존재하는 장소 + 카테고리 } 인지 검증 **/
    private void validateExistLoc(LocationId locationId){
        try{
            bucketlistRepository.findByPK(locationId)
                    .orElseThrow(() -> new IllegalStateException("잘못된 장소, 카테고리 쌍입니다."));

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /** { category, category_id } 가 유효한지 **/
    private void validateCategory(String category, int category_id){
        try{
            bucketlistRepository.findByPK(new Category_infoId(category, category_id))
                    .orElseThrow(() -> new IllegalStateException("잘못된 카테고리 분류 입니다."));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    /** category 목록 반환 **/
    public List<Category_info> category_infoList(){
        return bucketlistRepository.findAllCategory();
    }

    /** category 별로 속한 location 반환 **/
    public Location_info location_infoList(int lc_category){
        Location_info location_info = new Location_info(lc_category);
        List<Location> locations = bucketlistRepository.findByLc_category(lc_category);

        int length = locations.size();
        List<LocationData> locationDataList = new ArrayList<>();
        for(int i = 0; i < length; i++){
            locationDataList.add(new LocationData(
                    locations.get(i).getLocationId().getLc_id(),
                    locations.get(i).getLc_name()
                    ));
        }
        location_info.setLocationData(locationDataList);
        return location_info;
    }

    /** bucketlistContents의 장소와 사용자의 현재 위치중 일정 거리 내에 있는 활동만 반환 **/
    public List<LocationResponse> location_Rec(List<Bucketlist.BucketlistContents> bucketlistContentsList, String cur_x, String cur_y){
        List<LocationResponse> locationList = new ArrayList<>();
        int length = bucketlistContentsList.size();
        for(int i = 0; i < length; i++) {
            int finalI = i;
            bucketlistRepository.findByPK(new LocationId(
                    bucketlistContentsList.get(i).getLc_id(), bucketlistContentsList.get(i).getCategory_id()))
                    .ifPresent( location -> {
                        System.out.print("\n\n@@@ location name : " + bucketlistContentsList.get(finalI).getLc_name());
                        // 카테고리만 담은 경우(lc_id가 -로 시작하는경우)를 제외하고 1km 이내에 있는 장소만 반환
                        if (!location.getLocationId().getLc_id().startsWith("-") && distance(location.getLc_x(), location.getLc_y(), cur_x, cur_y) <= 1000.0) {
                            locationList.add(new LocationResponse(
                                    location,
                                    calStarRate(bucketlistContentsList.get(finalI).getLc_id()),
                                    bucketlistContentsList.get(finalI).getCategory(),
                                    recLocation(bucketlistContentsList.get(finalI).getLc_id())));
                        }
                        System.out.println(" @@@\n\n");
                    });
        }
        return locationList;
    }

    public List<LocationResponse> location_Info(List<Bucketlist.BucketlistContents> bucketlistContentsList, String lc_id){
        List<LocationResponse> locationList = new ArrayList<>();
        int length = bucketlistContentsList.size();
        for(AtomicInteger i = new AtomicInteger(); i.get() < length; i.getAndIncrement()) {
            bucketlistRepository.findByPK(new LocationId(
                            lc_id.replace("\n", ""), bucketlistContentsList.get(i.get()).getCategory_id()))
                    .ifPresent( location -> {
                        locationList.add(new LocationResponse(
                                location,
                                calStarRate(lc_id),
                                bucketlistContentsList.get(i.get()).getCategory(),
                                recLocation(bucketlistContentsList.get(i.get()).getLc_id())
                                ));
                        i.set(length + 1);
                    });
        }
        return locationList;
    }

    // 특정 장소와 연관된 장소들 구하기
    private List<Location> recLocation(String lc_id){
        List<Location> locationList = new ArrayList<Location>();
        bucketlistRepository.findByPK(lc_id)
                .ifPresent( recommend_location -> {
                    locationList.add(bucketlistRepository.findLocByLcId(recommend_location.getRecommend1()).get(0));
                    locationList.add(bucketlistRepository.findLocByLcId(recommend_location.getRecommend2()).get(0));
                    locationList.add(bucketlistRepository.findLocByLcId(recommend_location.getRecommend3()).get(0));
                });

        return locationList;
    }
    // 특정 장소의 평점 구하기
    private String calStarRate(String lc_id){
        DecimalFormat form = new DecimalFormat("#.##"); // 소수점 아래 두자리만 표현
        List<Review> reviewList = bucketlistRepository.findByLcId(lc_id);
        int length = reviewList.size();  // lc_id에 해당하는 장소에 리뷰가 있을때만 아래 코드 진행(평점 계산)
        if (length > 0) {
            int starRate = 0;
            for (int i = 0; i < length; i++) {
                starRate += reviewList.get(i).getRv_starrate();
            }
            return form.format(starRate / length * 0.1);
        }
        return "0.00"; // 없으면 0점 반환
    }
    // 두 위도 경도 간의 거리 구하기
    private double distance(String lc_x, String lc_y, String cur_x, String cur_y){
        double radius = 6371; // 지구 반지름(km)
        double toRadian = Math.PI / 180;
        double des_x = Double.parseDouble(lc_x);
        double des_y = Double.parseDouble(lc_y);
        double src_x = Double.parseDouble(cur_x);
        double src_y = Double.parseDouble(cur_y);

        double deltaLatitude = Math.abs(src_x - des_x) * toRadian;
        double deltaLongitude = Math.abs(src_y - des_y) * toRadian;

        double sinDeltaLat = Math.sin(deltaLatitude / 2);
        double sinDeltaLng = Math.sin(deltaLongitude / 2);
        double squareRoot = Math.sqrt(
                sinDeltaLat * sinDeltaLat +
                        Math.cos(src_x * toRadian) * Math.cos(des_x * toRadian) * sinDeltaLng * sinDeltaLng);

        System.out.print(" , distance is : " + 2 * radius * Math.asin(squareRoot) * 1000);
        return 2 * radius * Math.asin(squareRoot) * 1000;
    }
}
