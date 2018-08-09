package com.zylear.publish.spider.robot.web87g;

import com.zylear.publish.spider.robot.web87g.pipeline.Web87GPipeline;
import com.zylear.publish.spider.robot.web87g.pipeline.Web87GVideoPipeline;
import com.zylear.publish.spider.robot.web87g.processor.Web87GProcessor;
import com.zylear.publish.spider.robot.web87g.processor.Web87GVideoProcessor;
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

    private Web87GVideoProcessor web87GVideoProcessor;
    private Web87GVideoPipeline web87GVideoPipeline;


    public void startVideo() {
        Spider.create(web87GVideoProcessor)
                .addPipeline(web87GVideoPipeline)
                .addUrl("http://www.87g.com/pg/shipin/")
                .setExitWhenComplete(true)
                .thread(3)
                .runAsync();
    }

    public void start() {
        Spider.create(web87GProcessor)
                .addPipeline(web87GPipeline)
                .addUrl("http://www.87g.com/pg/gonglue/")
                .setExitWhenComplete(true)
                .thread(3)
                .runAsync();
    }

    @Autowired
    public void setWeb87GProcessor(Web87GProcessor web87GProcessor) {
        this.web87GProcessor = web87GProcessor;
    }

    @Autowired
    public void setWeb87GPipeline(Web87GPipeline web87GPipeline) {
        this.web87GPipeline = web87GPipeline;
    }

    @Autowired
    public void setWeb87GVideoProcessor(Web87GVideoProcessor web87GVideoProcessor) {
        this.web87GVideoProcessor = web87GVideoProcessor;
    }

    @Autowired
    public void setWeb87GVideoPipeline(Web87GVideoPipeline web87GVideoPipeline) {
        this.web87GVideoPipeline = web87GVideoPipeline;
    }
}
