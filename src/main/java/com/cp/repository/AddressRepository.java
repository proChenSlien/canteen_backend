package com.cp.repository;

import com.cp.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:08
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>,QuerydslPredicateExecutor<Address> {
    @Modifying
    @Query(value = "update Address set valid = 0 where id = ?1")
    void updateStaById(String id);
}
