package noobokmizz.noworever.controller;

import noobokmizz.noworever.dto.Bucketlist;
import noobokmizz.noworever.dto.DefaultResponse;
import noobokmizz.noworever.service.BucketlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return bucketlistService.findBKContents(bucketlist);
    }

    /** bucket list 에 새로운 활동을 담는 api **/
    @RequestMapping(value = "/bucketlist/add", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    @ResponseBody
    public DefaultResponse bucketlistAdd(@RequestBody Bucketlist.BucketlistSingleConetents bucketlistSingleConetents){
        return new DefaultResponse(bucketlistService.put(bucketlistSingleConetents));
    }

    /** bucket list 내의 활동 삭제 api **/
    public DefaultResponse bucketlistDelete(){
        return new DefaultResponse(1);
    }
    /** bucket list 에서 일정 거리 내에 있는 활동들의 정보만 반환하는 api **/
}
