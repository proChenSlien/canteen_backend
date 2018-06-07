package com.cp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *  简单的增删改查直接只用JpaRepository
 * @author : lf
 * @Date : 2017/6/26 14:44
 */
@NoRepositoryBean
public interface BaseService<T, ID>  extends JpaRepository<T, ID> {
    JpaRepository<T, ID> getRepository();

    Page<T> findAll(int page, int size, T entity);

    Page<T> findAll(int page, int size, T entity, Sort sort);
}
