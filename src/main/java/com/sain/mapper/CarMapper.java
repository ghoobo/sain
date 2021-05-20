package com.sain.mapper;

import com.sain.entity.Car;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarMapper {

    public int insert(Car car);

    public int delete(int id);

    public int updateCar(Car car);

    public int disinfection(int id);

    public void rentCar(String orderId);

    public int returnCar(String orderId);

    public int returnCarByTrial(String trialId);

    public int selectCountAll();

    public int selectCountByCon(@Param("number") String number, @Param("type") String type, @Param("adminId") int adminId);

    public Car selectOneById(int id);

    public List<Car> selectAll(@Param("offset") int offset, @Param("limit") int limit, @Param("type") String type, @Param("location") String location, @Param("gear") String gear, @Param("fuel") String fuel, @Param("minRent") Integer minRent, @Param("maxRent") Integer maxRent, @Param("brand") String brand);

    public List<Car> selectByCon(@Param("offset") int offset, @Param("limit") int limit, @Param("adminId") int adminId, @Param("number") String number, @Param("type") String type, @Param("location") String location, @Param("gear") String gear, @Param("fuel") String fuel, @Param("minRent") Integer minRent, @Param("maxRent") Integer maxRent);

    public List<Car> selectByType(String type);

    public List<Car> selectByBrand(String brand);

    public List<Car> selectByLocation(String location);

}
