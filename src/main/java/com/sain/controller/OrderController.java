package com.sain.controller;

import com.sain.entity.Admin;
import com.sain.entity.Condition;
import com.sain.entity.Order;
import com.sain.entity.User;
import com.sain.service.CarService;
import com.sain.service.OrderService;
import com.sain.util.DateUtil;
import com.sain.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CarService carService;

    @RequestMapping("/addOrder")
    public String addOrder(HttpSession session, Map map, Condition condition, int sumRent, int carId, String carBrand, String carModel, String tel, Integer day){

        StringBuilder orderTime = new StringBuilder("");
        Date date = new Date();
        orderTime.append(date.getYear()+1900);
        orderTime.append(date.getMonth()+1);
        orderTime.append(date.getDate());
        orderTime.append(date.getHours());
        orderTime.append(date.getMinutes());
        orderTime.append(date.getSeconds());

        Date takeTime = DateUtil.StringToDate(condition.getTakeDate()+" "+condition.getTakeTime());
        Date returnTime = null;
        if (day == null){
            returnTime = DateUtil.StringToDate(condition.getTakeDate()+" "+condition.getTakeTime());
        }else{
            if (day == 7){
                StringBuilder sb = new StringBuilder(condition.getTakeDate());
                sb.replace(8,10,(Integer.parseInt(condition.getTakeDate().substring(8,10))+7)+"");
                returnTime = DateUtil.StringToDate(sb+" "+condition.getTakeTime());
            }else if (day == 30){
                StringBuilder sb = new StringBuilder(condition.getTakeDate());
                sb.replace(5,7,(Integer.parseInt(condition.getTakeDate().substring(5,7))+1)+"");
                returnTime = DateUtil.StringToDate(sb+" "+condition.getTakeTime());
            }
        }
        User user = (User) session.getAttribute("user");
        Order order = new Order(orderTime+"",user.getId(),carId,null,takeTime,returnTime,condition.getTakeLocation(),condition.getReturnLocation(),sumRent,40,tel,0,null);
        orderService.addOrder(order);
        carService.rentCar(orderTime+"");
        map.put("WIDout_trade_no",orderTime);
        map.put("WIDtotal_amount",sumRent);
        map.put("WIDsubject",carBrand+" "+carModel);
        return "forward:/alipay/index.jsp";
    }

    @RequestMapping("/updateOrder")
    public String updateOrder(String out_trade_no){
        orderService.updateOrder(out_trade_no);
        MailUtils.sendSimpleMail("ghoobo@163.com","用户下订单","订单号:"+out_trade_no+"已付款，请及时准备车辆。");
        return "redirect:../user/index.html";
    }

    @RequestMapping("/takeCar")
    public @ResponseBody
    Map takeCar(String orderId){
        return orderService.takeCar(orderId);
    }

    @RequestMapping("/returnCar")
    public @ResponseBody
    Map returnCar(String orderId){
        carService.returnCar(orderId);
        return orderService.returnCar(orderId);
    }

    @RequestMapping("/showOrder")
    public @ResponseBody
    Map showOrder(HttpSession session, int page, int limit){
        User user = (User) session.getAttribute("user");
        Map map = orderService.showOrder(page,limit,user.getId());
        return map;
    }

    @RequestMapping("/selectOrderByAdmin")
    public @ResponseBody
    Map selectOrderByAdmin(HttpSession session,int page,int limit){
        Admin admin = (Admin) session.getAttribute("admin");
        Map map = orderService.selectOrderByAdmin(page,limit,admin.getId());
        return map;
    }

}
