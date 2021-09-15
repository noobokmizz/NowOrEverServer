package noobokmizz.noworever.controller;

import noobokmizz.noworever.service.BucketlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

    /** bucket list 에 새로운 활동을 담는 api **/

    /** bucket list 에서 일정 거리 내에 있는 활동들의 정보만 반환하는 api **/
}
