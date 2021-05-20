package com.sain.controller;

import com.sain.entity.User;
import com.sain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(User user){
        User user1 = userService.selectOneByTel(user.getUsername());
        if (user1 != null){
            return "redirect:../user/register.html";
        }else {
            userService.register(user);
            return "redirect:../user/login.html";
        }
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password){
        User user = userService.login(username, password);
        System.out.println("\033[32;4m" + user + "\033[0m");
        if (user==null){
            return null;
        }else {
            session.setAttribute("user",user);
            return "redirect:../user/index.html";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:../user/index.html";
    }

    @RequestMapping("")
    public String changePassword(HttpSession session, String password){
        int id = ((User)session.getAttribute("")).getId();
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        userService.changePassword(user);
        return "header.html";
    }

    @RequestMapping("/suspend")
    public @ResponseBody
    Map suspend(int id){
        return userService.suspend(id);
    }

    @RequestMapping("/open")
    public @ResponseBody
    Map open(int id){
        return userService.open(id);
    }

    @RequestMapping("selectAll")
    public @ResponseBody
    Map selectAll(int page, int limit){
        return userService.selectAll(page, limit);
    }

    @RequestMapping("/getSession")
    public @ResponseBody
    Map getSession(HttpSession session){
        Map map = new HashMap();
        User user = (User) session.getAttribute("user");
        map.put("user",user);
        System.out.println(map);
        return map;
    }

}
