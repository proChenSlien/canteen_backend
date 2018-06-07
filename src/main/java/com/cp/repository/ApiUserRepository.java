package com.cp.repository;

import com.cp.domain.UserApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 10:39
 */
@Repository
public interface ApiUserRepository extends JpaRepository<UserApi, Long>,QuerydslPredicateExecutor<UserApi> {

    @Modifying
    @Query(value = "update UserApi set valid = 0 where id = ?1")
    void updateStaById(String id);
}
