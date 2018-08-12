package com.zylear.publish.spider.controller;

import com.zylear.publish.spider.robot.duowan.DuowanSpiderManager;
import com.zylear.publish.spider.robot.web87g.Web87GSpiderManager;
import com.zylear.publish.spider.robot.yxdown.YxdownSpiderManager;
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
    private DuowanSpiderManager duowanSpiderManager;
    private YxdownSpiderManager yxdownSpiderManager;


    @ResponseBody
    @RequestMapping("/yxdown/article")
    public String startPubgArticle() {
        yxdownSpiderManager.startPubgArticle();
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/87g/article")
    public String control() {
        web87GSpiderManager.start();
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/87g/video")
    public String controlVideo() {
        web87GSpiderManager.startVideo();
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/duowan/article")
    public String startDuowanArticle() {
        duowanSpiderManager.startArticle();
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/duowan/video")
    public String startDuowanVideo() {
        duowanSpiderManager.startVideo();
        return "ok";
    }

    @Autowired
    public void setWeb87GSpiderManager(Web87GSpiderManager web87GSpiderManager) {
        this.web87GSpiderManager = web87GSpiderManager;
    }

    @Autowired
    public void setDuowanSpiderManager(DuowanSpiderManager duowanSpiderManager) {
        this.duowanSpiderManager = duowanSpiderManager;
    }

    @Autowired
    public void setYxdownSpiderManager(YxdownSpiderManager yxdownSpiderManager) {
        this.yxdownSpiderManager = yxdownSpiderManager;
    }
}
