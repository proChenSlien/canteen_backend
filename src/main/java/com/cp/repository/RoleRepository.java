package com.cp.repository;

import com.cp.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author liufeng
 * @create 2017/7/28 13:50
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
