package com.sain.service.impl;

import com.sain.entity.Car;
import com.sain.entity.Trial;
import com.sain.mapper.TrialMapper;
import com.sain.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrialServiceImpl implements TrialService {

    @Autowired
    private TrialMapper trialMapper;

    @Override
    public int addTrial(Trial trial) {
        return trialMapper.addTrial(trial);
    }

    @Override
    public Map audit(String id) {
        int count = trialMapper.audit(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isAudit","审核通过");
        }else{
            map.put("isAudit","更改失败");
        }
        return map;
    }

    @Override
    public Map takeCar(String id) {
        int count = trialMapper.takeCar(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isTake","取车成功");
        }else{
            map.put("isTake","更改失败");
        }
        return map;
    }

    @Override
    public Map returnCar(String id) {
        int count = trialMapper.returnCar(id);
        System.out.println(id);
        Map map = new HashMap();
        if(count>0){
            map.put("isReturn","还车成功");
        }else{
            map.put("isReturn","更改失败");
        }
        return map;
    }

    @Override
    public Map selectById(int page, int limit, int id) {
        int offset=(page-1)*limit;
        System.out.println(id);
        List<Trial> list = trialMapper.selectById(offset,limit,id);
        int count = trialMapper.selectCountById(id);
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @Override
    public Map selectByAdmin(int page, int limit, int id) {
        int offset=(page-1)*limit;
        List<Trial> list = trialMapper.selectByAdmin(offset,limit,id);
        int count = trialMapper.selectCountByAdmin(id);
        Map map = new HashMap();
        map.put("data",list);
        map.put("count",count);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

}
