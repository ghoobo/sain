package com.sain.mapper;

import com.sain.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface AdminMapper {

    public int addAdmin(@Param("name") String name,@Param("password") String password);

    public int suspend(int id);

    public int selectCount();

    @Transactional(readOnly = true)
    public Admin selectOne(@Param("name") String name,@Param("password") String password);

    public List<Admin> selectAll(@Param("offset") int offset, @Param("limit") int limit);

}
