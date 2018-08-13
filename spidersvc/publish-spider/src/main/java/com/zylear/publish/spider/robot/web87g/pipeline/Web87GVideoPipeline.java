package com.zylear.publish.spider.robot.web87g.pipeline;

import com.zylear.publish.spider.enums.SourceType;
import com.zylear.publish.spider.enums.SpiderCategory;
import com.zylear.publish.spider.enums.VideoType;
import com.zylear.publish.spider.manager.SpiderTxManager;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.robot.bean.SpiderVideo;
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

    private SpiderTxManager spiderTxManager;

    @Override
    public void process(ResultItems resultItems, Task task) {
        SpiderVideo video = resultItems.get("video");
        if (video != null) {
            spiderTxManager.saveVideo(VideoType.content_html.getValue(), SourceType.web_78g.getValue(), SpiderCategory.pubg.getValue(), video);
//            System.out.println(article);
        }

    }

    @Autowired
    public void setSpiderTxManager(SpiderTxManager spiderTxManager) {
        this.spiderTxManager = spiderTxManager;
    }
}
