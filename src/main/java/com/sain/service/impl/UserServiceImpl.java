package com.sain.service.impl;

import com.sain.entity.User;
import com.sain.mapper.UserMapper;
import com.sain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public void changePassword(User user) {
        userMapper.updatePassword(user);
    }

    @Override
    public Map suspend(int id) {
        int count = userMapper.suspend(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isSuspend","禁封成功");
        }else{
            map.put("isSuspend","禁封失败");
        }
        return map;
    }

    @Override
    public Map open(int id) {
        int count = userMapper.open(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isOpen","解封成功");
        }else{
            map.put("isOpen","解封失败");
        }
        return map;
    }

    @Override
    public User selectOneByTel(String username) {

        return null;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.selectOne(username,password);
        return user;
    }

    @Override
    public Map selectAll(int page, int limit) {
        int offset=(page-1)*limit;
        List<User> list = userMapper.selectAll(offset,limit);
        int count = userMapper.selectAllCount();
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

}
