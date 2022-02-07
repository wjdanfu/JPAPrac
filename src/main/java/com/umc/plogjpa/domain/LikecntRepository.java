package com.umc.plogjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikecntRepository extends JpaRepository<Likecnt,Long> {

    Optional<Integer> existsByUserIdxAndPostIdx(long userIdx, long postIdx);

    Optional<Likecnt> findByUserIdxAndPostIdx(long userIdx, long postIdx);

}
