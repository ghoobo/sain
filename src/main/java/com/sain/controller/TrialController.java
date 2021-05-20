package com.sain.controller;

import com.sain.entity.Admin;
import com.sain.entity.Condition;
import com.sain.entity.Trial;
import com.sain.entity.User;
import com.sain.service.CarService;
import com.sain.service.TrialService;
import com.sain.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/trial")
public class TrialController {

    @Autowired
    private TrialService trialService;

    @Autowired
    private CarService carService;

    @RequestMapping("/addTrial")
    public String addTrial(HttpSession session, int carId, Condition condition, String tel){
        StringBuilder orderTime = new StringBuilder("");
        Date date = new Date();
        orderTime.append(date.getYear()+1900);
        orderTime.append(date.getMonth()+1);
        orderTime.append(date.getDate());
        orderTime.append(date.getHours());
        orderTime.append(date.getMinutes());
        orderTime.append(date.getSeconds());
        Date takeTime = DateUtil.StringToDate(condition.getTakeDate()+" "+condition.getTakeTime());
        User user = (User) session.getAttribute("user");
        Trial trial = new Trial(orderTime+"",user.getId(),carId,null,takeTime,condition.getTakeLocation(),tel,0,null);
        trialService.addTrial(trial);
        return "redirect:/user/trialOrder.html";
    }

    @RequestMapping("/audit")
    public @ResponseBody
    Map audit(String id){
        return trialService.audit(id);
    }

    @RequestMapping("/takeCar")
    public @ResponseBody
    Map takeCar(String id){
        return trialService.takeCar(id);
    }

    @RequestMapping("/returnCar")
    public @ResponseBody
    Map returnCar(String id){
        carService.returnCarByTrial(id);
        return trialService.returnCar(id);
    }

    @RequestMapping("/selectAllById")
    public @ResponseBody
    Map selectAllById(HttpSession session, int page, int limit){
        User user = (User) session.getAttribute("user");
        Map map = trialService.selectById(page,limit,user.getId());
        return map;
    }

    @RequestMapping("/selectAllByAdmin")
    public @ResponseBody
    Map selectAllByAdmin(HttpSession session, int page, int limit){
        Admin admin = (Admin) session.getAttribute("admin");
        Map map = trialService.selectByAdmin(page,limit,admin.getId());
        return map;
    }

}
