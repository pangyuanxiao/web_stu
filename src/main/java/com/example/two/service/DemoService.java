package com.example.two.service;


import com.example.two.domain.Demo;
import com.example.two.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {


    @Resource

    private DemoMapper demoMapper;

    public List<Demo> list (){

        //这个selectByExample相当于where语句
        return demoMapper.selectByExample(null);
    }

}
