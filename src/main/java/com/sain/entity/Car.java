package com.sain.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private int id;
    private String type;
    private String brand;
    private String model;
    private String color;
    private int seat;
    private String gear;
    private String fuel;
    private String mainImage;
    private String frontImage;
    private String sideImage;
    private String rearImage;
    private int isRenting;
    private String location;
    private double rent;
    private String description;
    private int isDelete;
    private String number;
    private int adminId;
    private Admin admin;
    private int disinfection;

}
