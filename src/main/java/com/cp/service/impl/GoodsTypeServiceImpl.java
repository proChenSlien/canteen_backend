package com.cp.service.impl;

import com.cp.domain.GoodsType;
import com.cp.repository.GoodsTypeRepository;
import com.cp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: Slien
 * @Date: 2018-05-24 14:47
 */
@Service
public class GoodsTypeServiceImpl extends AbstractGenericServiceImpl<GoodsType, Long> implements GoodsTypeService {
    @Autowired
    private GoodsTypeRepository repository;
    @Override
    public JpaRepository<GoodsType, Long> getRepository() {
        return repository;
    }

    @Override
    @Transactional
    public void updateStaById(String id) {
        repository.updateStaById(id);
    }
}
