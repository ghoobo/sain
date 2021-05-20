package com.sain.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private int id;
    private String name;
    private String password;
    private int status;

}
