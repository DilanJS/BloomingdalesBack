package com.web.bloomingdales.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderInput {
    private String fullName;
    private String address;
    private String contactNumber;
    private List<OrderProductQuantity> orderProductQuantities;
}
