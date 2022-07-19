package com.example.two.service;


import com.example.two.domain.Ebook;
import com.example.two.domain.EbookExample;
import com.example.two.mapper.EbookMapper;
import com.example.two.req.EbookQueryReq;
import com.example.two.req.EbookSaveReq;
import com.example.two.resp.EbookQueryResp;
import com.example.two.resp.PageResp;
import com.example.two.utils.CopyUtil;
import com.example.two.utils.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG =LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;

    public PageResp<EbookQueryResp> list (EbookQueryReq rep){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

        if(!ObjectUtils.isEmpty(rep.getName())) {
            criteria.andNameLike("%" + rep.getName() + "%");
        }
        //从第一页开始，每页有三个  要注意一下这个只对最近的sql有效
        PageHelper.startPage(rep.getPage(), rep.getSize());
        //这个selectByExample相当于where语句
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        //循环ebookList里的实体，每个都变成 EbookResp 变成 EbookResp list

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());
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

        List<EbookQueryResp> respList = CopyUtil.copyList(ebookList, EbookQueryResp.class);

        PageResp<EbookQueryResp> pageResp = new PageResp();

        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);

        return pageResp;
    }

    public List<EbookQueryResp> all(){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();

//        if(!ObjectUtils.isEmpty(rep.getName())) {
//            criteria.andNameLike("%" + rep.getName() + "%");
//        }

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

        List<EbookQueryResp> respList = CopyUtil.copyList(ebookList, EbookQueryResp.class);



        return respList;
    }

    /*
        保存
     */
    public void save (EbookSaveReq req){
        Ebook ebook = CopyUtil.copy(req, Ebook.class);

        if (ObjectUtils.isEmpty(req.getId())){
            //new
            ebook.setId(snowFlake.nextId());
            ebookMapper.insert(ebook);
        }
        else {
            //update
            ebookMapper.updateByPrimaryKey(ebook);
        }

    }

}
