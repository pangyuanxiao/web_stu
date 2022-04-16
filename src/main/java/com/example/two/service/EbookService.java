package com.example.two.service;


import com.example.two.domain.Ebook;
import com.example.two.domain.EbookExample;
import com.example.two.mapper.EbookMapper;
import com.example.two.req.EbookReq;
import com.example.two.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {


    @Resource

    private EbookMapper ebookMapper;

    public List<EbookResp> list (EbookReq rep){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+rep.getName()+"%");

        //这个selectByExample相当于where语句
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        //循环ebookList里的实体，每个都变成 EbookResp 变成 EbookResp list

        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();
//            ebookResp.setId(ebook.getId());
//            这样一个一个写很麻烦

            BeanUtils.copyProperties(ebook,ebookResp);

            respList.add(ebookResp);
        }
        return respList;
    }

}
