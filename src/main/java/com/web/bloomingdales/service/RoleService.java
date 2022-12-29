package com.web.bloomingdales.service;

import com.web.bloomingdales.dao.RoleDao;
import com.web.bloomingdales.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService {


    private final RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
