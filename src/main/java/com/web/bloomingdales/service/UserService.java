package com.web.bloomingdales.service;

import com.web.bloomingdales.dao.RoleDao;
import com.web.bloomingdales.dao.UserDao;
import com.web.bloomingdales.entity.Role;
import com.web.bloomingdales.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerNewUser(User user){

        Role role=roleDao.findById("User").get();

        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword(getEncodePassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public void initRolesAndUser(){
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUsername("admin123");
        adminUser.setUserPassword(getEncodePassword("admin"));
        Set<Role>adminRoles =new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("Dilan");
        user.setUserLastName("Simonsz");
        user.setUsername("dilan123");
        user.setUserPassword(getEncodePassword("dil@pass"));
        Set<Role>userRoles =new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }
    public String getEncodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
