package com.example.two.controller;

import com.example.two.req.EbookReq;
import com.example.two.resp.CommonResp;
import com.example.two.resp.EbookResp;
import com.example.two.resp.PageResp;
import com.example.two.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController

@RequestMapping("/ebook")
//
public class EbookController {


    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(EbookReq rep) {
        CommonResp<PageResp<EbookResp>> resp = new CommonResp<>();
        PageResp<EbookResp> list = ebookService.list(rep);
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/list/all")
    public CommonResp all() {
        CommonResp<List<EbookResp>> resp_all = new CommonResp<>();
        List<EbookResp> list_all = ebookService.all();
        resp_all.setContent(list_all);
        return resp_all;
    }

}

