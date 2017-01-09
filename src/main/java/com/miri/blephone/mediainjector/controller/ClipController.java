package com.miri.blephone.mediainjector.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miri.blephone.mediainjector.db.domain.Clip;
import com.miri.blephone.mediainjector.db.mapper.ClipMapper;

@RestController
public class ClipController {

    @Autowired
    private ClipMapper categoryMapper;

    @RequestMapping("/clips")
    public Rsp<Clip> categorys(@RequestParam("draw") int draw, @RequestParam("start") int start,
            @RequestParam("length") int length, @RequestParam(name = "partname", required = false) String partname,
            @RequestParam(name = "serialno", required = false) int serialno,
            @RequestParam(name = "status", required = false) int status,
            @RequestParam(name = "originalid", required = false) String originalid,
            @RequestParam(name = "oriassetid", required = false) String oriassetid,
            @RequestParam(name = "assetid", required = false) String assetid,
            @RequestParam(name = "beginDate", required = false) Date beginDate,
            @RequestParam(name = "endDate", required = false) Date endDate) {
        Clip paramClip = new Clip();
        paramClip.setLimit(length);
        paramClip.setOffset(start);
        paramClip.setPartname(partname);
        paramClip.setSerialno(serialno);
        paramClip.setStatus(status);
        paramClip.setOriginalid(originalid);
        paramClip.setOriassetid(oriassetid);
        paramClip.setAssetid(assetid);
        paramClip.setBeginDate(beginDate);
        paramClip.setEndDate(endDate);

        int total = this.categoryMapper.queryClipsCount(paramClip);

        List<Clip> categories = this.categoryMapper.queryClips(paramClip);

        Rsp<Clip> rsp = new Rsp<Clip>();
        rsp.setData(categories);
        rsp.setDraw(draw);
        rsp.setRecordsTotal(total);
        rsp.setRecordsFiltered(total);

        return rsp;
    }

    @RequestMapping("/clips/{categoryOriginalid}")
    public Rsp<Clip> categorys(@PathVariable("categoryOriginalid") String categoryOriginalid,
            @RequestParam("draw") int draw, @RequestParam("start") int start, @RequestParam("length") int length,
            @RequestParam(name = "partname", required = false) String partname,
            @RequestParam(name = "serialno", required = false) int serialno,
            @RequestParam(name = "status", required = false) int status,
            @RequestParam(name = "originalid", required = false) String originalid) {
        Clip paramClip = new Clip();
        paramClip.setLimit(length);
        paramClip.setOffset(start);
        paramClip.setPartname(partname);
        paramClip.setSerialno(serialno);
        paramClip.setStatus(status);
        paramClip.setOriginalid(originalid);
        paramClip.setOriassetid(categoryOriginalid);

        int total = this.categoryMapper.queryClipsCount(paramClip);

        List<Clip> categories = this.categoryMapper.queryClips(paramClip);

        Rsp<Clip> rsp = new Rsp<Clip>();
        rsp.setData(categories);
        rsp.setDraw(draw);
        rsp.setRecordsTotal(total);
        rsp.setRecordsFiltered(total);

        return rsp;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        // 日期处理
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }
}
