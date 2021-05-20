package com.sain.mapper;

import com.sain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface UserMapper {

    public void insert(User user);

    public void updatePassword(User user);

    public int suspend(int id);

    public int open(int id);

    public int selectAllCount();

    @Transactional(readOnly = true)
    public User selectOne(@Param("username") String username, @Param("password") String password);

    public List<User> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    public void topUp(int id);

}
