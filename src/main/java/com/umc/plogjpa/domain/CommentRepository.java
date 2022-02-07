package com.umc.plogjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List findAllByPost_postIdx(@Param(value = "postIdx") long postIdx);

    Optional<Comment> findByCommentIdx(long commentIdx);
}
