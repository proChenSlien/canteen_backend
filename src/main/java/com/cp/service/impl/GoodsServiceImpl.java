package com.cp.service.impl;

import com.cp.domain.Goods;
import com.cp.repository.GoodsRepository;
import com.cp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:25
 */
@Service
public class GoodsServiceImpl extends AbstractGenericServiceImpl<Goods, Long> implements GoodsService {
    @Autowired
    private GoodsRepository repository;

    @Override
    public JpaRepository<Goods, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void updateStaById(String id) {
        repository.updateStaById(id);
    }

    @Override
    public Page getGoodsList(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        return repository.getGoodsList(pageRequest);
    }
}
