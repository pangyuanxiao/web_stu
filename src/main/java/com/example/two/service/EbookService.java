package com.example.two.service;


import com.example.two.domain.Ebook;
import com.example.two.domain.EbookExample;
import com.example.two.mapper.EbookMapper;
import com.example.two.req.EbookReq;
import com.example.two.resp.EbookResp;
import com.example.two.utils.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {


    @Resource

    private EbookMapper ebookMapper;

    public List<EbookResp> list (EbookReq rep){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        if(!ObjectUtils.isEmpty(rep.getName())) {
            criteria.andNameLike("%" + rep.getName() + "%");
        }
        //这个selectByExample相当于where语句
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        //循环ebookList里的实体，每个都变成 EbookResp 变成 EbookResp list

//        List<EbookResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(ebook,ebookResp);
//            respList.add(ebookResp);
//        }



//        使用复制工具类单个复制
//        for (Ebook ebook : ebookList) {
//            EbookResp resp = CopyUtil.copy(ebook,EbookResp.class);
//            respList.add(resp);
//        }

        List<EbookResp> respList = CopyUtil.copyList(ebookList,EbookResp.class);

        return respList;
    }

}
