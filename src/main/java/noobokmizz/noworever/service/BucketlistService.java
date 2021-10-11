package noobokmizz.noworever.service;

import noobokmizz.noworever.domain.Bkcontents;
import noobokmizz.noworever.dto.Bucketlist;
import noobokmizz.noworever.repository.BucketlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
@Service
public class BucketlistService {
    private final BucketlistRepository bucketlistRepository;

    public BucketlistService(BucketlistRepository bucketlistRepository){
        this.bucketlistRepository = bucketlistRepository;
    }

    /** 특정 id를 갖는 user 의 bucket list 목록 반환 api **/
    public Bucketlist.BucketlistMultipleContetns findBKContents(Bucketlist bucketlistDefaultRequest) {
        // BucketlistMultipleContents 객체 생성
        int mem_idnum = bucketlistDefaultRequest.getMem_idnum();
        int bk_id = bucketlistDefaultRequest.getBk_id();
        Bucketlist.BucketlistMultipleContetns ret = new Bucketlist.BucketlistMultipleContetns(mem_idnum, bk_id);

        // Bkcontents 값 설정
        List<Bkcontents> bkcontentsList = bucketlistRepository.findAllByIdAndBkId(mem_idnum, bk_id);
        int length = bkcontentsList.size();
        Bucketlist.BucketlistContents bucketlistContents[] = new Bucketlist.BucketlistContents[length];
        for(int i = 0; i<length; i++) {
            bucketlistContents[i] = new Bucketlist.BucketlistContents(
                    bkcontentsList.get(i).getCategory(), bkcontentsList.get(i).getLc_id()
            );
        }
        ret.setBucketlistContentsList(List.of(bucketlistContents));

        return ret;
    }

    /** 버킷리스트 내의 활동 중복 검증 **/

    /** bucket list 에 새로운 활동을 담는 api **/

    /** bucket list 에서 일정 거리 내에 있는 활동들의 정보만 반환하는 api **/
}
