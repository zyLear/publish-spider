package com.zylear.publish.spider.robot.yxdown;

import com.zylear.publish.spider.robot.web87g.pipeline.Web87GPipeline;
import com.zylear.publish.spider.robot.web87g.pipeline.Web87GVideoPipeline;
import com.zylear.publish.spider.robot.web87g.processor.Web87GProcessor;
import com.zylear.publish.spider.robot.web87g.processor.Web87GVideoProcessor;
import com.zylear.publish.spider.robot.yxdown.pipeline.YxdownPubgArticlePipeline;
import com.zylear.publish.spider.robot.yxdown.processor.YxdownPubgArticleProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * Created by xiezongyu on 2018/8/5.
 */
@Component
public class YxdownSpiderManager {


    private YxdownPubgArticlePipeline yxdownPubgArticlePipeline;
    private YxdownPubgArticleProcessor yxdownPubgArticleProcessor;

//    private Web87GVideoProcessor web87GVideoProcessor;
//    private Web87GVideoPipeline web87GVideoPipeline;


//    public void startVideo() {
//        Spider.create(web87GVideoProcessor)
//                .addPipeline(web87GVideoPipeline)
//                .addUrl("http://www.87g.com/pg/shipin/")
//                .setExitWhenComplete(true)
//                .thread(3)
//                .runAsync();
//    }

    public void startPubgArticle() {
        Spider.create(yxdownPubgArticleProcessor)
                .addPipeline(yxdownPubgArticlePipeline)
                .addUrl("http://www.yxdown.com/z/jdqscjzcsy/gl/")
                .setExitWhenComplete(true)
                .thread(3)
                .runAsync();
    }

    @Autowired
    public void setYxdownPubgArticlePipeline(YxdownPubgArticlePipeline yxdownPubgArticlePipeline) {
        this.yxdownPubgArticlePipeline = yxdownPubgArticlePipeline;
    }

    @Autowired
    public void setYxdownPubgArticleProcessor(YxdownPubgArticleProcessor yxdownPubgArticleProcessor) {
        this.yxdownPubgArticleProcessor = yxdownPubgArticleProcessor;
    }
}
