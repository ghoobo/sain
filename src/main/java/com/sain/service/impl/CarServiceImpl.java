package com.sain.service.impl;

import com.sain.entity.Car;
import com.sain.mapper.CarMapper;
import com.sain.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Map addCar(Car car) {
        int count = carMapper.insert(car);
        Map map = new HashMap();
        if(count>0){
            map.put("isAdd","添加成功");
        }else{
            map.put("isAdd","添加失败");
        }
        return map;
    }

    @Override
    public Map deleteCar(int id) {
        int count = carMapper.delete(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isDelete","删除成功");
        }else{
            map.put("isDelete","删除失败");
        }
        return map;
    }

    @Override
    public Map updateCar(Car car) {
        int count = carMapper.updateCar(car);
        Map map = new HashMap();
        if(count>0){
            map.put("isUpdate","修改成功");
        }else{
            map.put("isUpdate","修改失败");
        }
        return map;
    }

    @Override
    public Map disinfection(int id) {
        int count = carMapper.disinfection(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isDisinfection","修改成功");
        }else{
            map.put("isDisinfection","修改失败");
        }
        return map;
    }

    @Override
    public void rentCar(String orderId) {
        carMapper.rentCar(orderId);
    }

    @Override
    public void returnCar(String orderId) {
        carMapper.returnCar(orderId);
    }

    @Override
    public void returnCarByTrial(String trialId) {
        carMapper.returnCarByTrial(trialId);
    }

    @Override
    public Car selectOneById(int id) {
        return carMapper.selectOneById(id);
    }

    @Override
    public Map selectAll(int page,int limit, String type,String location,String gear,String fuel,Integer minRent,Integer maxRent,String brand) {
        int offset=(page-1)*limit;
        List<Car> list = carMapper.selectAll(offset,limit,type,location,gear,fuel,minRent,maxRent,brand);
        int count = carMapper.selectCountAll();
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        map.put("page",page);
        map.put("totalPage",count/limit);
        return map;
    }

    @Override
    public Map selectByCon(int page, int limit, int adminId, String number, String type,String location,String gear,String fuel,Integer minRent,Integer maxRent) {
        int offset=(page-1)*limit;
        List<Car> list = carMapper.selectByCon(offset,limit,adminId,number,type,location,gear,fuel,minRent,maxRent);
        int count = carMapper.selectCountByCon(number, type ,adminId);
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @Override
    public List<Car> selectByType(String type) {
        return carMapper.selectByType(type);
    }

    @Override
    public List<Car> selectByBrand(String brand) {
        return carMapper.selectByBrand(brand);
    }

    @Override
    public List<Car> selectByLocation(String location) {
        return carMapper.selectByLocation(location);
    }

}
