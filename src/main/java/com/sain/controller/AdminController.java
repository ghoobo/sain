package com.sain.controller;

import com.sain.entity.Admin;
import com.sain.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/addAdmin")
    public String addAdmin(String name,String password){
        adminService.addAdmin(name, password);
        return "redirect:/admin/views/admin.html";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String name, String password){
        Admin admin = adminService.login(name, password);
        if (admin==null){
            return null;
        }else {
            session.setAttribute("admin",admin);
            return "redirect:/admin/index.html";
        }
    }

    @RequestMapping("/suspend")
    public @ResponseBody
    Map suspend(int id){
        return adminService.suspend(id);
    }

    @RequestMapping("/selectAll")
    public @ResponseBody
    Map selectAll(int page, int limit){
        return adminService.selectAll(page, limit);
    }

    @RequestMapping("/getSession")
    public @ResponseBody
    Map getSession(HttpSession session){
        Map map = new HashMap();
        Admin admin = (Admin)session.getAttribute("admin");
        map.put("admin",admin.getName());
        return map;
    }

}
