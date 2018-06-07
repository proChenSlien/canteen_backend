package com.cp.repository.custom.impl;

import com.cp.domain.QUser;
import com.cp.dto.UserDTO;
import com.cp.repository.custom.UserRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 自定义方法实现，使用querydsl做复杂查询
 * @author : lf
 * @Date : 2017/6/20 11:01
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    protected EntityManager em;

    @Override
    public List<UserDTO> custom() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        JPAQuery<UserDTO> jpaQuery =queryFactory
                                    .select(Projections.bean(UserDTO.class, QUser.user.username))
                                    .from(QUser.user)
                                    .where(QUser.user.username.like("u%"));
        return jpaQuery.fetch();
    }
}
