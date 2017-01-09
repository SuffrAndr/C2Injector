package com.miri.blephone.mediainjector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/files/index")
    public String files() {
        return "file";
    }

    @RequestMapping("/clips/index")
    public String clips() {
        return "clip";
    }

    @RequestMapping("/clips/index/{categoryOriginalid}")
    public String clips(@PathVariable("categoryOriginalid") String categoryOriginalid, ModelMap map) {
        map.addAttribute("categoryOriginalid", categoryOriginalid);
        return "clip2";
    }

    @RequestMapping("/login")

    public String login() {
        return "login";
    }
}
