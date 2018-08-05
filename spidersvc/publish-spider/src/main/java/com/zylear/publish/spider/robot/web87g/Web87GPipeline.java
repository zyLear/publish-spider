package com.zylear.publish.spider.robot.web87g;

import com.zylear.publish.spider.manager.Web87GTxManager;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.service.pubilsh.ArticleContentService;
import com.zylear.publish.spider.service.pubilsh.ArticleService;
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

    private Web87GTxManager web87GTxManager;


    @Override
    public void process(ResultItems resultItems, Task task) {
        SpiderArticle article = resultItems.get("article");
        if (article != null) {
            web87GTxManager.saveArticle(article);
        }

    }

    @Autowired
    public void setWeb87GTxManager(Web87GTxManager web87GTxManager) {
        this.web87GTxManager = web87GTxManager;
    }
}
