package com.sain.service;

import com.sain.entity.Trial;

import java.util.List;
import java.util.Map;

public interface TrialService {

    public int addTrial(Trial trial);

    public Map audit(String id);

    public Map takeCar(String id);

    public Map returnCar(String id);

    public Map selectById(int page, int limit, int id);

    public Map selectByAdmin(int page, int limit, int id);

}
