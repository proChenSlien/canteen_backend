package com.cp.service;

import com.cp.domain.Address;

/**
 * @author: Slien
 * @Date: 2018-05-24 11:31
 */
public interface AddressService extends BaseService<Address, Long>{
    void updateStaById(String id);
}
