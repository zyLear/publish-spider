package com.zylear.publish.spider.controller;

import com.zylear.publish.spider.manager.SubmitManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiezongyu on 2018/8/10.
 */
@Controller
@RequestMapping("/submit")
public class SubmitController {

    @Autowired
    private SubmitManager submitManager;

    @ResponseBody
    @RequestMapping("/article")
    public String startArticle() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                submitManager.submitArticle();
            }
        }).start();
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/video")
    public String startVideo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                submitManager.submitVideo();
            }
        }).start();
        return "ok";
    }

}
