package com.sain.service;

import com.sain.entity.User;

import java.util.Map;

public interface UserService {

    public void register(User user);

    public void changePassword(User user);

    public Map suspend(int id);

    public Map open(int id);

    public User selectOneByTel(String username);

    public User login(String username, String password);

    public Map selectAll(int page, int limit);

}
