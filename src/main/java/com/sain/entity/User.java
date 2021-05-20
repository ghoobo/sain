package com.sain.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String username;
    private String password;
    private String realName;
    private String identity;
    private String archives;
    private int isVip;

}
