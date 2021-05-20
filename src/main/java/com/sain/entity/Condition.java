package com.sain.entity;

import lombok.*;

import java.util.Date;
import java.util.Timer;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Condition {

    private String takeLocation;
    private String returnLocation;
    private String takeDate;
    private String returnDate;
    private String takeTime;
    private String returnTime;
    private String gear;
    private String fuel;
    private Integer minRent;
    private Integer maxRent;

}
