package com.zylear.publish.spider.manager;

import com.zylear.publish.spider.config.DataSourceSpiderConfig;
import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;
import com.zylear.publish.spider.domain.Video;
import com.zylear.publish.spider.enums.SourceType;
import com.zylear.publish.spider.enums.VideoType;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.service.pubilsh.ArticleContentService;
import com.zylear.publish.spider.service.pubilsh.ArticleService;
import com.zylear.publish.spider.service.pubilsh.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by xiezongyu on 2018/8/5.
 */
@Component
public class Web87GTxManager {

    private static final Logger logger = LoggerFactory.getLogger(Web87GTxManager.class);

    private ArticleService articleService;
    private ArticleContentService articleContentService;
    private VideoService videoService;

    @Transactional(DataSourceSpiderConfig.TX_MANAGER)
    public void saveArticle(SpiderArticle spiderArticle) {

        Article exist = articleService.findBySourceTypeAndTitle(SourceType.web_78g.getValue(), spiderArticle.getTitle());

        if (exist != null) {
            logger.info("article exist. sourceType:{} title:{}", SourceType.web_78g.getValue(), spiderArticle.getTitle());
            return;
        }

        Date date = new Date();
        ArticleContentWithBLOBs articleContent = new ArticleContentWithBLOBs();
        articleContent.setCss(spiderArticle.getCss());
        articleContent.setContent(spiderArticle.getContent());
        articleContent.setIsDeleted(false);
        articleContent.setCreateTime(date);
        articleContent.setLastUpdateTime(date);
        articleContentService.insert(articleContent);

        Article article = new Article();
        article.setArticleCategory(1);
        article.setSourceType(1);
        article.setSourceUrl(spiderArticle.getSourceUrl());
        article.setTitle(spiderArticle.getTitle());
        article.setPostTime(null);
        article.setContentId(articleContent.getId());
        article.setPageView(0);
        article.setIsDeleted(false);
        article.setCreateTime(date);
        article.setLastUpdateTime(date);
        articleService.insert(article);
        logger.info("save article:{}", spiderArticle);

    }

    public void saveVideo(SpiderArticle spiderArticle) {
        Video exist = videoService.findBySourceTypeAndTitle(SourceType.web_78g.getValue(), spiderArticle.getTitle());

        if (exist != null) {
            logger.info("video exist. sourceType:{} title:{}", SourceType.web_78g.getValue(), spiderArticle.getTitle());
            return;
        }

        Date date = new Date();
        ArticleContentWithBLOBs articleContent = new ArticleContentWithBLOBs();
        articleContent.setCss(spiderArticle.getCss());
        articleContent.setContent(spiderArticle.getContent());
        articleContent.setIsDeleted(false);
        articleContent.setCreateTime(date);
        articleContent.setLastUpdateTime(date);
        articleContentService.insert(articleContent);

        Video video = new Video();
        video.setArticleCategory(1);
        video.setSourceType(1);
        video.setSourceUrl(spiderArticle.getSourceUrl());
        video.setTitle(spiderArticle.getTitle());
        video.setPostTime(null);
        video.setContentId(articleContent.getId());
        video.setPageView(0);
        video.setIsDeleted(false);
        video.setCreateTime(date);
        video.setLastUpdateTime(date);
        video.setVideoType(VideoType.comtent_html.getValue());
        videoService.insert(video);
        logger.info("save video:{}", spiderArticle);
    }


    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setArticleContentService(ArticleContentService articleContentService) {
        this.articleContentService = articleContentService;
    }

    @Autowired
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }
}
