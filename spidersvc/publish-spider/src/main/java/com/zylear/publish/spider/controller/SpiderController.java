package com.zylear.publish.spider.controller;

import com.zylear.publish.spider.robot.web87g.Web87GSpiderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiezongyu on 2018/8/5.
 */
@Controller
@RequestMapping("/grab")
public class SpiderController {

    private Web87GSpiderManager web87GSpiderManager;

    @RequestMapping("/87g/article")
    @ResponseBody
    public String control() {


        web87GSpiderManager.start();

        return "ok";
    }

    @RequestMapping("/87g/video")
    @ResponseBody
    public String controlVideo() {


        web87GSpiderManager.startVideo();

        return "ok";
    }

    @Autowired
    public void setWeb87GSpiderManager(Web87GSpiderManager web87GSpiderManager) {
        this.web87GSpiderManager = web87GSpiderManager;
    }
}
