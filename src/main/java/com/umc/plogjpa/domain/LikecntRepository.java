package com.umc.plogjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikecntRepository extends JpaRepository<Likecnt,Long> {

    boolean existsByUser_userIdxAndPost_postIdx(long userIdx, long postIdx);

    void deleteByUser_userIdxAndPost_postIdx(long userIdx, long postIdx);

    int countByPost_postIdx(long postIdx);
}
