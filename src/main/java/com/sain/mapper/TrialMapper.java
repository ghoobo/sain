package com.sain.mapper;

import com.sain.entity.Car;
import com.sain.entity.Trial;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrialMapper {

    public int addTrial(Trial trial);

    public int audit(String id);

    public int takeCar(String id);

    public int returnCar(String id);

    public int selectCountById(int id);

    public int selectCountByAdmin(int id);

    public List<Trial> selectById(@Param("offset") int offset, @Param("limit") int limit, @Param("id") int id);

    public List<Trial> selectByAdmin(@Param("offset") int offset, @Param("limit") int limit, @Param("id") int id);

}
