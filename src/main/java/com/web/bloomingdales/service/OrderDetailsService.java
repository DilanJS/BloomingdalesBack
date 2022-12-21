package com.web.bloomingdales.service;

import com.web.bloomingdales.configuration.JwtRequestFilter;
import com.web.bloomingdales.dao.OrderDetailDao;
import com.web.bloomingdales.dao.ProductDao;
import com.web.bloomingdales.dao.UserDao;
import com.web.bloomingdales.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    private static final String ORDER_PLACED="Placed";

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    public void placeOrder(OrderInput orderInput){
        List<OrderProductQuantity> productQuantityList =orderInput.getOrderProductQuantities();

        for (OrderProductQuantity o: productQuantityList){
            Product product=productDao.findById(o.getProductId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(currentUser).get();

            OrderDetail orderDetail=new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getAddress(),
                    orderInput.getContactNumber(),
                    ORDER_PLACED,
                    product.getProductDiscountedPrice() * o.getQuantity(),
                    product,
                    user
            );

            orderDetailDao.save(orderDetail);
        }
    }
}
