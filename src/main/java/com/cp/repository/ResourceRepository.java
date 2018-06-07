package com.cp.repository;

import com.cp.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO 资源
 *
 * @author liufeng
 * @create 2017/7/28 13:48
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource,String> {

    Resource findByPath(String path);

    List<Resource> findByParentIdIsNull();

}
