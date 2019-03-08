package com.jxy.service;

import com.jxy.hEntity.Role;
import com.jxy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoleServiceRe extends BaseServiceImp<Role>{
    @Autowired
    private RoleRepository roleRepository;
}
