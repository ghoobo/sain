package com.sain.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Trial {

    private String trialId;
    private int userId;
    private int carId;
    private Date trialTime;
    private Date takeTime;
    private String takeLocation;
    private String tel;
    private int status;
    private Car car;

}
