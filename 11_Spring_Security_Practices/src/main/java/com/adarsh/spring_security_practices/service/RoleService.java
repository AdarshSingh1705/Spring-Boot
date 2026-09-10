package com.adarsh.spring_security_practices.service;

import com.adarsh.spring_security_practices.entity.Role;
import com.adarsh.spring_security_practices.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }
}
