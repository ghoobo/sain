package com.sain.controller;

import com.sain.entity.Request;
import com.sain.service.RequestService;
import com.sain.util.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping("/addRequest")
    public String addRequest(Request request){
        requestService.addRequest(request);
        MailUtils.sendSimpleMail("ghoobo@163.com","合作申请",request.getText()+"<br/>--------------------------------------------------<br/>"+request.getName()+"<br/>"+request.getTel()+"<br/>"+request.getEmail());
        return "redirect:../user/contact.html";
    }

    @RequestMapping("/selectAll")
    public @ResponseBody
    Map selectAll(int page, int limit){
        Map map = requestService.selectAll(page, limit);
        return map;
    }

}
