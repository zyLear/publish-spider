package com.zylear.publish.spider.robot.duowan.pipeline;

import com.zylear.publish.spider.enums.SourceType;
import com.zylear.publish.spider.enums.SpiderCategory;
import com.zylear.publish.spider.enums.VideoType;
import com.zylear.publish.spider.manager.SpiderTxManager;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.robot.bean.SpiderVideo;
import com.zylear.publish.spider.robot.web87g.pipeline.Web87GPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created by xiezongyu on 2018/8/8.
 */
@Component
public class DuowanVideoPipeline implements Pipeline {


    private static final Logger logger = LoggerFactory.getLogger(Web87GPipeline.class);

    private SpiderTxManager spiderTxManager;


    @Override
    public void process(ResultItems resultItems, Task task) {
        SpiderVideo video = resultItems.get("video");
        if (video != null) {
            spiderTxManager.saveVideo(VideoType.embed.getValue(), SourceType.duowan.getValue(), SpiderCategory.lol.getValue(), video);
        }

    }

    @Autowired
    public void setSpiderTxManager(SpiderTxManager spiderTxManager) {
        this.spiderTxManager = spiderTxManager;
    }
}
