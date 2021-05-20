package com.sain.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private int userId;
    private int carId;
    private Date orderTime;
    private Date takeTime;
    private Date returnTime;
    private String takeLocation;
    private String returnLocation;
    private double rentPrice;
    private double servicePrice;
    private String tel;
    private int isPay;
    private Car car;

}
