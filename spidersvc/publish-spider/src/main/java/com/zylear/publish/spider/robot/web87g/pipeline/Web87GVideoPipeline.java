package com.zylear.publish.spider.robot.web87g.pipeline;

import com.zylear.publish.spider.manager.Web87GTxManager;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by xiezongyu on 2018/8/7.
 */
@Component
public class Web87GVideoPipeline implements Pipeline {

    private Web87GTxManager web87GTxManager;

    @Override
    public void process(ResultItems resultItems, Task task) {
        SpiderArticle article = resultItems.get("article");
        if (article != null) {
            web87GTxManager.saveVideo(article);
//            System.out.println(article);
        }

    }

    @Autowired
    public void setWeb87GTxManager(Web87GTxManager web87GTxManager) {
        this.web87GTxManager = web87GTxManager;
    }
}
