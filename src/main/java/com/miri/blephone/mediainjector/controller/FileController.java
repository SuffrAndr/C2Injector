package com.miri.blephone.mediainjector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miri.blephone.mediainjector.db.domain.File;
import com.miri.blephone.mediainjector.db.mapper.FileMapper;

@RestController
public class FileController {

    @Autowired
    private FileMapper fileMapper;

    @RequestMapping("/files")
    public Rsp<File> categorys(@RequestParam("draw") int draw, @RequestParam("start") int start,
            @RequestParam("length") int length, @RequestParam(name = "status", required = false) int status,
            @RequestParam(name = "downloadStatus", required = false) int downloadStatus,
            @RequestParam(name = "fileformatdesc", required = false) int fileformatdesc,
            @RequestParam(name = "oriassetid", required = false) String oriassetid,
            @RequestParam(name = "oripartid", required = false) String oripartid,
            @RequestParam(name = "assetid", required = false) String assetid) {
        File paramFile = new File();
        paramFile.setLimit(length);
        paramFile.setOffset(start);
        paramFile.setStatus(status);
        paramFile.setDownloadStatus(downloadStatus);
        paramFile.setFileformatdesc(fileformatdesc);
        paramFile.setOriassetid(oriassetid);
        paramFile.setOripartid(oripartid);
        paramFile.setAssetid(assetid);

        int total = this.fileMapper.queryFilesCount(paramFile);

        List<File> categories = this.fileMapper.queryFiles(paramFile);

        Rsp<File> rsp = new Rsp<File>();
        rsp.setData(categories);
        rsp.setDraw(draw);
        rsp.setRecordsTotal(total);
        rsp.setRecordsFiltered(total);

        return rsp;
    }

    @RequestMapping("/queryfiles")
    public Rsp<File> files(@RequestParam("oripartid") String oripartid, @RequestParam("draw") int draw,
            @RequestParam("start") int start, @RequestParam("length") int length,
            @RequestParam(name = "status", required = false) int status,
            @RequestParam(name = "downloadStatus", required = false) int downloadStatus,
            @RequestParam(name = "fileformatdesc", required = false) int fileformatdesc) {
        File paramFile = new File();
        paramFile.setLimit(length);
        paramFile.setOffset(start);
        paramFile.setStatus(status);
        paramFile.setDownloadStatus(downloadStatus);
        paramFile.setFileformatdesc(fileformatdesc);
        paramFile.setOripartid(oripartid);

        int total = this.fileMapper.queryFilesCount(paramFile);

        List<File> categories = this.fileMapper.queryFiles(paramFile);

        Rsp<File> rsp = new Rsp<File>();
        rsp.setData(categories);
        rsp.setDraw(draw);
        rsp.setRecordsTotal(total);
        rsp.setRecordsFiltered(total);

        return rsp;
    }
}
