package com.cp.service.impl;

import com.cp.domain.Resource;
import com.cp.dto.AuthorityDto;
import com.cp.repository.ResourceRepository;
import com.cp.service.ResourceService;
import com.cp.utils.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/28 15:20
 */
public class ResourceServiceImpl extends AbstractGenericServiceImpl<Resource, String> implements ResourceService {

    @Autowired
    private ResourceRepository repository;


    @Override
    public void updateOrInsert(List<AuthorityDto> auths) {
        cycSave(auths, null);
    }

    @Override
    public List<Resource> getRoot() {
        return repository.findByParentIdIsNull();
    }

    private void cycSave(List<AuthorityDto> auths, Resource parent) {
        auths.forEach((au) -> {
            Resource p = saveIt(au, parent);
            List<AuthorityDto> children = au.getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                cycSave(children, p);
            }
        });
    }

    private Resource saveIt(AuthorityDto auth, Resource parent) {

        Resource resource = new Resource();
        resource.setPath(auth.getPath());
        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.DEFAULT); //构建对象
        Example<Resource> ex = Example.of(resource, matcher);
        List<Resource> list = repository.findAll(ex);
        if (list.size() > 0) {
            resource.setId(list.get(0).getId());
        } else {
            resource.setId(PrimaryKeyUtil.getTableID());
        }

        resource.setName(auth.getName());
        resource.setResource(auth.getResource());
        resource.setParent(parent);
        return repository.save(resource);
    }


    @Override
    public JpaRepository getRepository() {
        return repository;
    }
}
