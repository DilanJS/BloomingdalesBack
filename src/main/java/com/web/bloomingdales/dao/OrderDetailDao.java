package com.web.bloomingdales.dao;


import com.web.bloomingdales.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailDao extends CrudRepository<OrderDetail,Integer> {

}
