package com.cp.service;


import com.cp.domain.Order;

/**
 * @author: Slien
 * @Date: 2018-05-24 15:25
 */
public interface OrderService extends BaseService<Order, Long>{

    void updateStaById(String id);
}
