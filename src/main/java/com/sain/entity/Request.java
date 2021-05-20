package com.sain.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    private int id;
    private String name;
    private String email;
    private String tel;
    private String location;
    private String text;

}
