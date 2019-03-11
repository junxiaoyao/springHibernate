package com.jxy.service;

import com.jxy.entity.Role;
import com.jxy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceRe extends BaseServiceImp<Role>{
    @Autowired
    private RoleRepository roleRepository;
}
