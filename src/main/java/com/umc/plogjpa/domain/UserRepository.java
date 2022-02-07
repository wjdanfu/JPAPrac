package com.umc.plogjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserIdx(long userIdx);
    Optional<User> findByName(String name);
}
