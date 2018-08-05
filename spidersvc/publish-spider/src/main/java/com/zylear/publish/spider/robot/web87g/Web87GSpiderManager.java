package com.zylear.publish.spider.robot.web87g;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * Created by xiezongyu on 2018/8/5.
 */
@Component
public class Web87GSpiderManager {


    private Web87GProcessor web87GProcessor;
    private Web87GPipeline web87GPipeline;


    public void start() {
        Spider.create(web87GProcessor)
                .addPipeline(web87GPipeline)
                .addUrl("http://www.87g.com/pg/gonglue/")
                .setExitWhenComplete(true)
                .thread(3)
                .runAsync();

//        new Thread() {
//            @Override
//            public void run() {
//                go();
//            }
//        }.start();

    }

    @Autowired
    public void setWeb87GProcessor(Web87GProcessor web87GProcessor) {
        this.web87GProcessor = web87GProcessor;
    }

    @Autowired
    public void setWeb87GPipeline(Web87GPipeline web87GPipeline) {
        this.web87GPipeline = web87GPipeline;
    }
}
