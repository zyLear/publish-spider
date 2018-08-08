package com.zylear.publish.spider.robot.duowan;

import com.zylear.publish.spider.robot.duowan.pipeline.DuowanArticlePipeline;
import com.zylear.publish.spider.robot.duowan.processor.DuowanArticleProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * Created by xiezongyu on 2018/8/8.
 */
@Component
public class DuowanSpiderManager {

    private DuowanArticleProcessor duowanArticleProcessor;
    private DuowanArticlePipeline duowanArticlePipeline;


//    public void startVideo() {
//        Spider.create(web87GVideoProcessor)
//                .addPipeline(web87GVideoPipeline)
//                .addUrl("http://www.87g.com/pg/shipin/")
//                .setExitWhenComplete(true)
//                .thread(3)
//                .runAsync();
//    }

    public void startArticle() {
        Spider.create(duowanArticleProcessor)
                .addPipeline(duowanArticlePipeline)
                .addUrl("http://lol.duowan.com/tag/131563991792.html")
                .setExitWhenComplete(true)
                .thread(3)
                .runAsync();
    }

    @Autowired
    public void setDuowanArticleProcessor(DuowanArticleProcessor duowanArticleProcessor) {
        this.duowanArticleProcessor = duowanArticleProcessor;
    }

    @Autowired
    public void setDuowanArticlePipeline(DuowanArticlePipeline duowanArticlePipeline) {
        this.duowanArticlePipeline = duowanArticlePipeline;
    }
}
