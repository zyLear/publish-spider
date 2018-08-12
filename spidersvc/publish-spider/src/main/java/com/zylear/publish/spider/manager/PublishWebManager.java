package com.zylear.publish.spider.manager;

import com.zylear.publish.spider.manager.bean.ArticlePostBean;
import com.zylear.publish.spider.manager.bean.SubmitResponse;
import com.zylear.publish.spider.manager.bean.VideoPostBean;
import com.zylear.publish.spider.util.JsonUtil;
import com.zylear.publish.spider.util.OkHttpUtil;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.util.concurrent.TimeUnit;

/**
 * Created by xiezongyu on 2018/8/8.
 */
@Component
public class PublishWebManager {

    private static final Logger logger = LoggerFactory.getLogger(PublishWebManager.class);

    @Value("${publish.web.host}")
    private String host;
    private String submitArticleUri = "/admin/submit-article";
    private String submitVideoUri = "/admin/submit-video";

    public Integer submitArticle(ArticlePostBean articlePostBean) {
        String url = host + submitArticleUri;
        String jsonString = JsonUtil.toJSONString(articlePostBean);
        return submit(url, jsonString);
    }


    public Integer submitVideo(VideoPostBean videoPostBean) {
        String url = host + submitVideoUri;
        String jsonString = JsonUtil.toJSONString(videoPostBean);
        return submit(url, jsonString);

    }

    private Integer submit(String url, String jsonString) {

        try {
            Response response = OkHttpUtil.syncExecJsonPost(url, jsonString);
            String string = response.body().string();
            SubmitResponse submitResponse = JsonUtil.getObjectFromJson(string, SubmitResponse.class);
            if (submitResponse.getErrorCode() == 0) {
                return submitResponse.getRefId();
            }
        } catch (Exception e) {
            logger.info("submit fail. jsonString:{}", jsonString, e);
        }

        return -1;
    }


}
