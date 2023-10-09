package com.example.two.controller;

import com.example.two.req.EbookQueryReq;
import com.example.two.req.EbookSaveReq;
import com.example.two.resp.CommonResp;
import com.example.two.resp.EbookQueryResp;
import com.example.two.resp.PageResp;
import com.example.two.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController

@RequestMapping("/ebook")
//
public class EbookController {


    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq rep) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        PageResp<EbookQueryResp> list = ebookService.list(rep);
        resp.setContent(list);
        return resp;
    }


    @PostMapping("/save")
    //json格式需要加注解 @RequestBody
    public CommonResp save(@Valid @RequestBody EbookSaveReq rep) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        ebookService.save(rep);

        return resp;
    }


    @DeleteMapping("/delete/{id}")
    //json格式需要加注解 @RequestBody
    public CommonResp delete(@PathVariable Long id) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        ebookService.delete(id);

        return resp;
    }


    @GetMapping("/list/all")
    public CommonResp all() {
        CommonResp<List<EbookQueryResp>> resp_all = new CommonResp<>();
        List<EbookQueryResp> list_all = ebookService.all();
        resp_all.setContent(list_all);
        return resp_all;
    }

}

