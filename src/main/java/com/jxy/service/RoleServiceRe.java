package com.jxy.service;

import com.jxy.hEntity.Role;
import com.jxy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoleServiceRe {
    @Autowired
    private RoleRepository roleRepository;
    public void testSave(){
        Role roleEntity=new Role();
        roleEntity.setUserId(9);
        roleEntity.setRoleName("测试插入");
        roleEntity.setRoleId(9);
        roleEntity.setCreateTime(new Date().toString());
        roleEntity.setRemark("测试");
        roleEntity.setUserName("rss");
        roleRepository.save(roleEntity);
    }
    public Role getOne(){
       Role role= roleRepository.getById(1l);
       return role;
    }
}
