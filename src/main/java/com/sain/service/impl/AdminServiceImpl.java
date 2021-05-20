package com.sain.service.impl;

import com.sain.entity.Admin;
import com.sain.mapper.AdminMapper;
import com.sain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int addAdmin(String name, String password) {
        return adminMapper.addAdmin(name, password);
    }

    @Override
    public Map suspend(int id) {
        int count = adminMapper.suspend(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isSuspend","删除成功");
        }else{
            map.put("isSuspend","删除失败");
        }
        return map;
    }

    @Override
    public Admin login(String name, String password) {
        return adminMapper.selectOne(name,password);
    }

    @Override
    public @ResponseBody
    Map selectAll(int page, int limit) {
        int offset=(page-1)*limit;
        List<Admin> list = adminMapper.selectAll(offset,limit);
        int count = adminMapper.selectCount();
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

}
