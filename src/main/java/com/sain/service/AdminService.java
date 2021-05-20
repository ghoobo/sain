package com.sain.service;

import com.sain.entity.Admin;

import java.util.Map;

public interface AdminService {

    public int addAdmin(String name, String password);

    public Map suspend(int id);

    public Admin login(String name, String password);

    public Map selectAll(int page, int limit);

}
