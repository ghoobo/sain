package com.sain.controller;

import com.sain.entity.Admin;
import com.sain.entity.Car;
import com.sain.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("/addCar")
    public @ResponseBody
    Map addCar(Car car, HttpSession session){
        Admin admin = (Admin)session.getAttribute("admin");
        car.setAdminId(admin.getId());
        String mainImage = car.getMainImage().substring(car.getMainImage().lastIndexOf("\\"));
        car.setMainImage(mainImage);
        return carService.addCar(car);
    }

    @RequestMapping("/upload")
    public @ResponseBody
    Map upload(MultipartFile mainImage, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/carImage");
        mainImage.transferTo(new File(realPath+"/"+mainImage.getOriginalFilename()));
        Map map = new HashMap();
        map.put("isUpload","上传成功");
        return map;
    }

    @RequestMapping("/deleteCar")
    public @ResponseBody
    Map deleteCar(int id){
        return carService.deleteCar(id);
    }

    @RequestMapping("/selectOneById")
    public @ResponseBody
    Car selectOneById(int id){
        Car car = carService.selectOneById(id);
        return car;
    }

    @RequestMapping("/updateCar")
    public @ResponseBody
    Map updateCar(Car car){
        return carService.updateCar(car);
    }

    @RequestMapping("/disinfection")
    public @ResponseBody
    Map disinfection(int id){
        return carService.disinfection(id);
    }

    /*
    主页的热门车型查询前八个
     */
    @RequestMapping("/selectMain")
    public @ResponseBody
    Map selectMain(){
        return carService.selectAll(2,8,"","","","",null,null,"");
    }

    @RequestMapping("/selectAll")
    public @ResponseBody
    Map selectAll(HttpSession session, Map<String,Object> param, int page, String takeDate, String takeTime, String type, String location, String gear, String fuel, Integer minRent, Integer maxRent, String brand){
        /*Map map = new HashMap();
        map.put("page",page);
        map.put("list",carService.selectAll(page,12));*/
        System.out.println("\033[32;4m" + takeDate + "\033[0m");
        System.out.println("\033[32;4m" + takeTime + "\033[0m");
        System.out.println("\033[32;4m" + type + "\033[0m");
        System.out.println("\033[32;4m" + maxRent + "\033[0m");
        Map condition = new HashMap();
        condition.put("type",type);
        condition.put("location",location);
        condition.put("gear",gear);
        condition.put("fuel",fuel);
        condition.put("minRent",minRent);
        condition.put("maxRent",maxRent);
        session.setAttribute("condition",condition);
        if (location != null){
            String newLocation = location.substring(0,location.indexOf('市')+1);
            location = newLocation;
        }
        Map map = carService.selectAll(page,12,type,location,gear,fuel,minRent,maxRent,brand);
        return map;
    }

    @RequestMapping("/selectByCon")
    public @ResponseBody
    Map selectByCon(HttpSession session, int page,int limit,String number,String type,String location,String gear,String fuel,Integer minRent,Integer maxRent){
        int adminId = ((Admin)session.getAttribute("admin")).getId();
        return carService.selectByCon(page,limit,adminId,number,type,location,gear,fuel,minRent,maxRent);
    }

    @RequestMapping("/getSession")
    public @ResponseBody
    Map getSession(HttpSession session){
        Map map = new HashMap();
        map = (Map) session.getAttribute("condition");
        return map;
    }

}
