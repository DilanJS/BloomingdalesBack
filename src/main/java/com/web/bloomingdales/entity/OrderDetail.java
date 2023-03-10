package com.web.bloomingdales.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer orderId;

    private  String orderFullName;
    private String orderFullAddress;
    private String orderContactNumber;
    private String orderStatus;
    private Double orderAmount;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    public OrderDetail(String orderFullName, String orderFullAddress, String orderContactNumber, String orderStatus, Double orderAmount, Product product, User user) {
        this.orderFullName = orderFullName;
        this.orderFullAddress = orderFullAddress;
        this.orderContactNumber = orderContactNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
    }
}
