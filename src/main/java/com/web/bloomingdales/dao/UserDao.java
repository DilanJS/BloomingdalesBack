package com.web.bloomingdales.dao;

import com.web.bloomingdales.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,String> {

}
