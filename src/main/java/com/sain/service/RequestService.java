package com.sain.service;

import com.sain.entity.Request;

import java.util.Map;

public interface RequestService {

    public void addRequest(Request request);

    public Map selectAll(int page,int limit);

}
