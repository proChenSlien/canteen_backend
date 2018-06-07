package com.cp.repository;

import com.cp.domain.User;
import com.cp.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * 大部分方法自动生成
 * @author : lf
 * @Date : 2017/6/20 9:38
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>, QuerydslPredicateExecutor<User>, UserRepositoryCustom {

    User findByUsername(String userName);
}
