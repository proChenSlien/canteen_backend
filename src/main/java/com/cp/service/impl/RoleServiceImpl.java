package com.cp.service.impl;

import com.cp.domain.Resource;
import com.cp.domain.Role;
import com.cp.repository.ResourceRepository;
import com.cp.repository.RoleRepository;
import com.cp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/28 15:18
 */
@Service
public class RoleServiceImpl extends AbstractGenericServiceImpl<Role, Long> implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private ResourceRepository resourceRepository;


    @Override
    public JpaRepository<Role, Long> getRepository() {
        return repository;
    }



    @Override
    public void correlateResource(List<String> resourceIds, Long userId) {
        Role role = repository.getOne(userId);
        List<Resource> selected = resourceRepository.findAllById(resourceIds);
        role.setResources(selected);
        repository.save(role);
    }

}
