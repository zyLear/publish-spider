package com.zylear.publish.spider.robot.web87g.pipeline;

import com.zylear.publish.spider.manager.SpiderTxManager;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by xiezongyu on 2018/8/5.
 */
@Component
public class Web87GPipeline implements Pipeline{

    private static final Logger logger = LoggerFactory.getLogger(Web87GPipeline.class);

    private SpiderTxManager spiderTxManager;


    @Override
    public void process(ResultItems resultItems, Task task) {
        SpiderArticle article = resultItems.get("article");
        if (article != null) {
            spiderTxManager.save87GArticle(article);
        }

    }

    @Autowired
    public void setSpiderTxManager(SpiderTxManager spiderTxManager) {
        this.spiderTxManager = spiderTxManager;
    }
}
