package com.miri.blephone.mediainjector.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miri.blephone.mediainjector.db.domain.Category;
import com.miri.blephone.mediainjector.db.mapper.CategoryMapper;

@RestController
public class CategoryController {

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("/categorys")
    public Rsp<Category> categorys(@RequestParam("draw") int draw, @RequestParam("start") int start,
            @RequestParam("length") int length, @RequestParam(name = "clipname", required = false) String clipname,
            @RequestParam(name = "assetid", required = false) String assetid,
            @RequestParam(name = "status", required = false) int status,
            @RequestParam(name = "beginDate", required = false) Date beginDate,
            @RequestParam(name = "endDate", required = false) Date endDate) {
        Category paramCategory = new Category();
        paramCategory.setLimit(length);
        paramCategory.setOffset(start);
        paramCategory.setClipname(clipname);
        paramCategory.setStatus(status);
        paramCategory.setAssetid(assetid);
        paramCategory.setBeginDate(beginDate);
        paramCategory.setEndDate(endDate);

        int total = this.categoryMapper.queryCategorysCount(paramCategory);

        List<Category> categories = this.categoryMapper.queryCategorys(paramCategory);

        Rsp<Category> rsp = new Rsp<Category>();
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
