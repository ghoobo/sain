package com.sain.service;

import com.sain.entity.Car;

import java.util.List;
import java.util.Map;

public interface CarService {

    public Map addCar(Car car);

    public Map deleteCar(int id);

    public Map updateCar(Car car);

    public Map disinfection(int id);

    public void rentCar(String orderId);

    public void returnCar(String orderId);

    public void returnCarByTrial(String trialId);

    public Car selectOneById(int id);

    public Map selectAll(int page,int limit,String type,String location,String gear,String fuel,Integer minRent,Integer maxRent, String brand);

    public Map selectByCon(int page,int limit,int adminId,String number,String type,String location,String gear,String fuel,Integer minRent,Integer maxRent);

    public List<Car> selectByType(String type);

    public List<Car> selectByBrand(String brand);

    public List<Car> selectByLocation(String location);

}
