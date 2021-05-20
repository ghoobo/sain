package com.sain.mapper;

import com.sain.entity.Request;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RequestMapper {

    public void addRequest(Request request);

    public int selectAllCount();

    public List<Request> selectAll(@Param("offset") int offset, @Param("limit") int limit);

}
