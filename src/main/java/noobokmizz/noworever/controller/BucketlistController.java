package noobokmizz.noworever.controller;

import noobokmizz.noworever.domain.Location;
import noobokmizz.noworever.dto.*;
import noobokmizz.noworever.service.BucketlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller 에는 @Controller 어노테이션
 * Service 에는 @Service 어노테이션
 * Repository 에는 @Repository 어노테이션을 붙여서 스프링이 관리하도록
 *
 * Controller 를 통해서 외부 요청을 받고
 * Service 에서 비즈니스 로직을 만들고
 * Repository 에서 데이터를 저장
 * 하는게 정형화된 패턴
 **/
@RestController
public class BucketlistController {
    private final BucketlistService bucketlistService;

    @Autowired
    public BucketlistController(BucketlistService bucketlistService){
        this.bucketlistService = bucketlistService;
    }

    /** 특정 id를 갖는 user 의 bucket list 목록 반환 api **/
    @PostMapping("/bucketlist/show")
    @ResponseBody  // http의 응답 body부에 이 데이터를 직접 넣겠다(api를 통해 데이터를 바로 내리겠다).
    public Bucketlist.BucketlistMultipleContetns bucketlistRead(@RequestBody Bucketlist bucketlist){
        return bucketlistService.show(bucketlist);
    }

    /** bucket list 에 새로운 활동을 담는 api **/
    @PostMapping(value = "/bucketlist/add")
    @ResponseBody
    public DefaultResponse bucketlistAdd(@RequestBody Bucketlist.BucketlistSingleConetents bucketlistSingleConetents){
        return new DefaultResponse(bucketlistService.put(bucketlistSingleConetents));
    }

    /** bucket list 내의 활동 삭제 api **/
    @PostMapping("/bucketlist/delete")
    @ResponseBody
    public DefaultResponse bucketlistDelete(@RequestBody Bucketlist.BucketlistMultipleContetns bucketlistMultipleContetns){
        return new DefaultResponse(bucketlistService.delete(bucketlistMultipleContetns));
    }

    /** bucket list 에서 일정 거리 내에 있는 활동들의 정보만 반환하는 api **/
    @GetMapping("/bucketlist/recommendation")
    @ResponseBody
    public List<LocationResponse> bucketlistReco(@RequestParam int mem_idnum, @RequestParam int bk_id, @RequestParam String cur_x, @RequestParam String cur_y){
        List<Bucketlist.BucketlistContents> bucketlistContentsList =
                bucketlistService.show(new Bucketlist(mem_idnum, bk_id)).getBucketlistContentsList();
        return bucketlistService.location_Rec(bucketlistContentsList, cur_x, cur_y);
    }

    /** bucket list 내에 저장한 장소의 경로 api **/
    @GetMapping("/bucketlist/path")
    @ResponseBody
    public List<LocationResponse> bucketlistPath(@RequestParam int mem_idnum, @RequestParam int bk_id, @RequestParam String lc_id){
        List<Bucketlist.BucketlistContents> bucketlistContentsList =
                bucketlistService.show(new Bucketlist(mem_idnum, bk_id)).getBucketlistContentsList();
        return bucketlistService.location_Info(bucketlistContentsList, lc_id);
    }

    /** category 목록과 category 별로 속한 location 반환 **/
    @GetMapping("/categorylist")
    @ResponseBody
    public CategoryAndLocationLIst categoryAndLocRead(){
        CategoryAndLocationLIst categoryAndLocationLIst = new CategoryAndLocationLIst();
        // cateogory 목록 가져옴
        categoryAndLocationLIst.setCategory_info(bucketlistService.category_infoList());

        List<Location_info> location_infoList = new ArrayList<>();
        int length = categoryAndLocationLIst.getCategory_info().size();
        for(int i = 0; i < length; i++){
            // cateogory 별 location 가져옴
            location_infoList.add(bucketlistService.location_infoList(categoryAndLocationLIst.getCategory_info().get(i).getCategory_id()));
        }
        categoryAndLocationLIst.setLocation_info(location_infoList);
        return categoryAndLocationLIst;
    }
}
