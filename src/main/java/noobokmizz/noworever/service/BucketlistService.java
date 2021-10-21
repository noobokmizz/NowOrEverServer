package noobokmizz.noworever.service;

import noobokmizz.noworever.domain.Bkcontents;
import noobokmizz.noworever.domain.BkcontentsId;
import noobokmizz.noworever.domain.LocationId;
import noobokmizz.noworever.dto.Bucketlist;
import noobokmizz.noworever.repository.BucketlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.*;
import java.util.List;

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
                    bkcontentsList.get(i).getBkcontentsId().getLc_id()
            );
        }
        ret.setBucketlistContentsList(List.of(bucketlistContents));
        return ret;
    }

    /** bucket list 에 새로운 활동을 담는 api **/
    public int put(Bucketlist.BucketlistSingleConetents bucketlistSingleConetents){
        try {
            LocationId locationId = new LocationId(
                    bucketlistSingleConetents.getBucketlistContents().getLc_id(),
                    bucketlistSingleConetents.getBucketlistContents().getCategory_id());
            validateExistLoc(locationId); // 존재하는 {장소, 카테고리} 쌍인지 확인

            BkcontentsId bkcontentsId = new BkcontentsId(
                    bucketlistSingleConetents.getMem_idnum(),
                    bucketlistSingleConetents.getBk_id(),
                    bucketlistSingleConetents.getBucketlistContents().getLc_id(),
                    bucketlistSingleConetents.getBucketlistContents().getCategory_id()
            );

            validateDuplicateAct(bkcontentsId);  // 버킷리스트에 이미 존재하는 활동인지 검증


            bucketlistRepository.save(new Bkcontents(bkcontentsId));
        }catch (Exception e){
            if(e.getMessage()=="버킷리스트에 이미 존재하는 활동입니다." || e.getMessage() == "잘못된 장소, 카테고리 쌍입니다."){
                return 0;
            }
        }
        return 1;
    }
    /** bucket list 내의 활동 삭제 **/
    public int delete(Bucketlist.BucketlistMultipleContetns bucketlistMultipleContetns){
        for(int i = 0; i < bucketlistMultipleContetns.getBucketlistContentsList().size(); i++) {
            BkcontentsId bkcontentsId = new BkcontentsId();
            bkcontentsId.setMem_idnum(bucketlistMultipleContetns.getMem_idnum());
            bkcontentsId.setBk_id(bucketlistMultipleContetns.getBk_id());
            bkcontentsId.setLc_id(bucketlistMultipleContetns.getBucketlistContentsList().get(i).getLc_id());
            bkcontentsId.setCategory_id(bucketlistMultipleContetns.getBucketlistContentsList().get(i).getCategory_id());

            // 삭제하고자 하는 데이터가 존재한다면 삭제
            bucketlistRepository.findByPK(bkcontentsId)
                    .ifPresent(
                            bkc -> bucketlistRepository.delete(bkc)
                    );
        }
        return 1;
    }
    /** bucket list 에 있는 활동인지 중복 검증 **/
    public void validateDuplicateAct(BkcontentsId bkcontentsId){
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

    /** location 에 { 존재하는 장소 + 카테고리 } 인지 검증 **/
    public void validateExistLoc(LocationId locationId){
        try{
            bucketlistRepository.findByPK(locationId)
                    .orElseThrow(() -> new IllegalStateException("잘못된 장소, 카테고리 쌍입니다."));
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    /** bucket list 에서 일정 거리 내에 있는 활동들의 정보만 반환하는 api **/
}
