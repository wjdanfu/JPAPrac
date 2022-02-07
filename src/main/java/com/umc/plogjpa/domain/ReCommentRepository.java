package com.umc.plogjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReCommentRepository extends JpaRepository<ReComment,Long> {

    List findAllByComment_commentIdx(@Param(value = "commentIdx") long commentIdx);
}
