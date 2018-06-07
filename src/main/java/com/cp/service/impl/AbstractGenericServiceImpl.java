package com.cp.service.impl;

import com.cp.service.BaseService;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 大量默认方法
 *
 * @author : lf
 * @Date : 2017/6/26 14:50
 */
public abstract class AbstractGenericServiceImpl<T, ID> implements BaseService<T, ID> {

    @Override
    public abstract JpaRepository<T, ID> getRepository();


    @Override
    public Page<T> findAll(int page, int size, T entity) {
        PageRequest pageRequest = PageRequest.of(page, size);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); //构建对象 String 都是like
        Example<T> ex = Example.of(entity, matcher);
        return getRepository().findAll(ex, pageRequest);
    }

    @Override
    public Page<T> findAll(int page, int size, T entity, Sort sort) {
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); //构建对象 String 都是like
        Example<T> ex = Example.of(entity, matcher);
        return getRepository().findAll(ex, pageRequest);
    }

    @Override
    public <S extends T> S save(S s) {
        return getRepository().save(s);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public List<T> findAllById(Iterable<ID> iterable) {
        return getRepository().findAllById(iterable);
    }

    @Override
    public <S extends T> List<S> saveAll(Iterable<S> iterable) {
        return getRepository().saveAll(iterable);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {
        return getRepository().saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<T> iterable) {
        getRepository().deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        getRepository().deleteAllInBatch();
    }

    @Override
    public T getOne(ID id) {
        return getRepository().getOne(id);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return getRepository().existsById(id);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(T t) {
        getRepository().delete(t);
    }

    @Override
    public void deleteAll(Iterable<? extends T> iterable) {
        getRepository().deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return getRepository().findOne(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return getRepository().findAll(example);
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return getRepository().findAll(example, sort);
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return getRepository().findAll(example, pageable);
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return getRepository().count(example);
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return getRepository().exists(example);
    }
}
