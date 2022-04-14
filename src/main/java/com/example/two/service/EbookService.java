package com.example.two.service;


import com.example.two.domain.Ebook;
import com.example.two.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {


    @Resource

    private EbookMapper ebookMapper;

    public List<Ebook> list (){

        //这个selectByExample相当于where语句
        return ebookMapper.selectByExample(null);
    }

}
