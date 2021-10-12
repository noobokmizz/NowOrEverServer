package noobokmizz.noworever.service;

import noobokmizz.noworever.domain.Bkcontents;
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

    /** bucket list 에 새로운 활동을 담는 api **/
    public int put(Bucketlist.BucketlistSingleConetents bucketlistSingleConetents){
        try {
            valiateDuplicateAct(
                    bucketlistSingleConetents.getMem_idnum(), bucketlistSingleConetents.getBk_id(),
                    bucketlistSingleConetents.getBucketlistContents().getLc_id(),
                    bucketlistSingleConetents.getBucketlistContents().getCategory()
            );
        }catch (Exception e){
            if(e.getMessage()=="버킷리스트에 이미 존재하는 활동입니다."){
                return 0;
            }
        }

        Bkcontents bkcontents = new Bkcontents();
        bkcontents.setMem_idnum(bucketlistSingleConetents.getMem_idnum());
        bkcontents.setBk_id(bucketlistSingleConetents.getBk_id());
        bkcontents.setLc_id(bucketlistSingleConetents.getBucketlistContents().getLc_id());
        bkcontents.setCategory(bucketlistSingleConetents.getBucketlistContents().getCategory());
        bucketlistRepository.save(bkcontents);
        return 1;
    }

    /** 버킷리스트 내의 활동 중복 검증 **/
    public void valiateDuplicateAct(int mem_idnum, int bk_id, String lc_id, String category){
        try {
            bucketlistRepository.findByPK(mem_idnum, bk_id, lc_id, category)
                    .ifPresent(u -> {
                        throw new IllegalStateException("버킷리스트에 이미 존재하는 활동입니다.");
                    });
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /** bucket list 에서 일정 거리 내에 있는 활동들의 정보만 반환하는 api **/
}
