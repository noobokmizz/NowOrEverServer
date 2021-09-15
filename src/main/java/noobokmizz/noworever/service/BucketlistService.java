package noobokmizz.noworever.service;

import noobokmizz.noworever.repository.BucketlistRepository;
import org.springframework.stereotype.Service;

@Service
public class BucketlistService {
    private final BucketlistRepository bucketlistRepository;

    public BucketlistService(BucketlistRepository bucketlistRepository){
        this.bucketlistRepository = bucketlistRepository;
    }

    /** 특정 id를 갖는 user 의 bucket list 목록 반환 api **/

    /** 버킷리스트 내의 활동 중복 검증 **/

    /** bucket list 에 새로운 활동을 담는 api **/

    /** bucket list 에서 일정 거리 내에 있는 활동들의 정보만 반환하는 api **/
}
