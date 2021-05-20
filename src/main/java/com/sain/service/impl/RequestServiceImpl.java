package com.sain.service.impl;

import com.sain.entity.Request;
import com.sain.mapper.RequestMapper;
import com.sain.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestMapper requestMapper;

    @Override
    public void addRequest(Request request) {
        requestMapper.addRequest(request);
    }

    @Override
    public Map selectAll(int page,int limit) {
        int offset=(page-1)*limit;
        List<Request> list = requestMapper.selectAll(offset,limit);
        int count = requestMapper.selectAllCount();
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        map.put("page",page);
        map.put("totalPage",count/limit);
        return map;
    }

}
