package com.zylear.publish.spider.manager;

import com.zylear.publish.spider.config.DataSourceSpiderConfig;
import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;
import com.zylear.publish.spider.domain.Video;
import com.zylear.publish.spider.enums.SourceType;
import com.zylear.publish.spider.enums.SpiderCategory;
import com.zylear.publish.spider.enums.VideoType;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.robot.bean.SpiderVideo;
import com.zylear.publish.spider.service.pubilsh.ArticleContentService;
import com.zylear.publish.spider.service.pubilsh.ArticleService;
import com.zylear.publish.spider.service.pubilsh.VideoService;
import com.zylear.publish.spider.util.DateUtil;
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
public class SpiderTxManager {

    private static final Logger logger = LoggerFactory.getLogger(SpiderTxManager.class);

    private ArticleService articleService;
    private ArticleContentService articleContentService;
    private VideoService videoService;


    @Transactional(DataSourceSpiderConfig.TX_MANAGER)
    public void saveArticle(SpiderArticle spiderArticle, Integer sourceType, Integer spiderCategory) {
        Article exist = articleService.findBySourceTypeAndTitle(sourceType, spiderArticle.getTitle());

        if (exist != null) {
            logger.info("article exist. sourceType:{} title:{}", SourceType.valueOf(sourceType), spiderArticle.getTitle());
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
        article.setSpiderCategory(spiderCategory);
        article.setSourceType(sourceType);
        article.setSourceUrl(spiderArticle.getSourceUrl());
        article.setTitle(spiderArticle.getTitle());
        article.setPostTime(getPostTimeDate(sourceType, spiderArticle.getPostTime()));
        article.setContentId(articleContent.getId());
        article.setPageView(0);
        article.setIsDeleted(false);
        article.setCreateTime(date);
        article.setLastUpdateTime(date);
        articleService.insert(article);
        logger.info("save souceType:{} article:{}", SourceType.valueOf(sourceType), spiderArticle);
    }


//    @Transactional(DataSourceSpiderConfig.TX_MANAGER)
//    public void save87GArticle(SpiderArticle spiderArticle) {
//
//        Article exist = articleService.findBySourceTypeAndTitle(SourceType.web_78g.getValue(), spiderArticle.getTitle());
//
//        if (exist != null) {
//            logger.info("article exist. sourceType:{} title:{}", SourceType.web_78g.getValue(), spiderArticle.getTitle());
//            return;
//        }
//
//        Date date = new Date();
//        ArticleContentWithBLOBs articleContent = new ArticleContentWithBLOBs();
//        articleContent.setCss(spiderArticle.getCss());
//        articleContent.setContent(spiderArticle.getContent());
//        articleContent.setIsDeleted(false);
//        articleContent.setCreateTime(date);
//        articleContent.setLastUpdateTime(date);
//        articleContentService.insert(articleContent);
//
//        Article article = new Article();
//        article.setSpiderCategory(SpiderCategory.pubg.getValue());
//        article.setSourceType(SourceType.web_78g.getValue());
//        article.setSourceUrl(spiderArticle.getSourceUrl());
//        article.setTitle(spiderArticle.getTitle());
//        article.setPostTime(DateUtil.getDateFromYDMHMS(spiderArticle.getPostTime()));
//        article.setContentId(articleContent.getId());
//        article.setPageView(0);
//        article.setIsDeleted(false);
//        article.setCreateTime(date);
//        article.setLastUpdateTime(date);
//        articleService.insert(article);
//        logger.info("save article:{}", spiderArticle);
//
//    }

//    @Transactional(DataSourceSpiderConfig.TX_MANAGER)
//    public void saveVideo(SpiderArticle spiderArticle) {
//        Video exist = videoService.findBySourceTypeAndTitle(SourceType.web_78g.getValue(), spiderArticle.getTitle());
//
//        if (exist != null) {
//            logger.info("video exist. sourceType:{} title:{}", SourceType.web_78g.getValue(), spiderArticle.getTitle());
//            return;
//        }
//
//        Date date = new Date();
//        ArticleContentWithBLOBs articleContent = new ArticleContentWithBLOBs();
//        articleContent.setCss(spiderArticle.getCss());
//        articleContent.setContent(spiderArticle.getContent());
//        articleContent.setIsDeleted(false);
//        articleContent.setCreateTime(date);
//        articleContent.setLastUpdateTime(date);
//        articleContentService.insert(articleContent);
//
//        Video video = new Video();
//        video.setVideoCategory(SpiderCategory.pubg.getValue());
//        video.setSourceType(SourceType.web_78g.getValue());
//        video.setSourceUrl(spiderArticle.getSourceUrl());
//        video.setTitle(spiderArticle.getTitle());
//        video.setPostTime(DateUtil.getDateFromYDMHMS(spiderArticle.getPostTime()));
//        video.setContentId(articleContent.getId());
//        video.setPageView(0);
//        video.setIsDeleted(false);
//        video.setCreateTime(date);
//        video.setLastUpdateTime(date);
//        video.setVideoType(VideoType.content_html.getValue());
//        videoService.insert(video);
//        logger.info("save video:{}", spiderArticle);
//    }

//    @Transactional(DataSourceSpiderConfig.TX_MANAGER)
//    public void saveDuowanArticle(SpiderArticle spiderArticle) {
//
//        Article exist = articleService.findBySourceTypeAndTitle(SourceType.duowan.getValue(), spiderArticle.getTitle());
//
//        if (exist != null) {
//            logger.info("article exist. sourceType:{} title:{}", SourceType.duowan.getValue(), spiderArticle.getTitle());
//            return;
//        }
//
//        Date date = new Date();
//        ArticleContentWithBLOBs articleContent = new ArticleContentWithBLOBs();
//        articleContent.setCss(spiderArticle.getCss());
//        articleContent.setContent(spiderArticle.getContent());
//        articleContent.setIsDeleted(false);
//        articleContent.setCreateTime(date);
//        articleContent.setLastUpdateTime(date);
//        articleContentService.insert(articleContent);
//
//        Article article = new Article();
//        article.setSpiderCategory(SpiderCategory.lol.getValue());
//        article.setSourceType(SourceType.duowan.getValue());
//        article.setSourceUrl(spiderArticle.getSourceUrl());
//        article.setTitle(spiderArticle.getTitle());
//        article.setPostTime(DateUtil.getDateFromYDMHMS(spiderArticle.getPostTime()));
//        article.setContentId(articleContent.getId());
//        article.setPageView(0);
//        article.setIsDeleted(false);
//        article.setCreateTime(date);
//        article.setLastUpdateTime(date);
//        articleService.insert(article);
//        logger.info("save duowan article:{}", spiderArticle);
//
//    }


    @Transactional(DataSourceSpiderConfig.TX_MANAGER)
    public void saveVideo(Integer videoType, Integer sourceType, Integer category, SpiderVideo spiderVideo) {

        Video exist = videoService.findBySourceTypeAndTitle(sourceType, spiderVideo.getTitle());

        if (exist != null) {
            logger.info("video exist. sourceType:{} title:{}", SourceType.valueOf(sourceType), spiderVideo.getTitle());
            return;
        }

        Date date = new Date();
        ArticleContentWithBLOBs articleContent = null;
        if (VideoType.content_html.getValue().equals(videoType)) {
            articleContent = new ArticleContentWithBLOBs();
            articleContent.setCss(spiderVideo.getCss());
            articleContent.setContent(spiderVideo.getContent());
            articleContent.setIsDeleted(false);
            articleContent.setCreateTime(date);
            articleContent.setLastUpdateTime(date);
            articleContentService.insert(articleContent);
        }

        Video video = new Video();
        video.setVideoType(category);
        video.setVideoCategory(category);
        video.setSourceType(sourceType);
        video.setSourceUrl(spiderVideo.getSourceUrl());
        video.setTitle(spiderVideo.getTitle());
        video.setCoverImgUrl(spiderVideo.getCoverImgUrl());
        video.setVideoSource(spiderVideo.getVideoSource());
        video.setFlashvars(spiderVideo.getFlashvars());
        video.setPostTime(getPostTimeDate(sourceType, spiderVideo.getPostTime()));
        if (articleContent != null) {
            video.setContentId(articleContent.getId());
        }
        video.setPageView(0);
        video.setIsDeleted(false);
        video.setCreateTime(date);
        video.setLastUpdateTime(date);
        videoService.insert(video);
        logger.info("save sourceType:{} video:{}", SourceType.valueOf(sourceType), spiderVideo);


    }

    private Date getPostTimeDate(Integer sourceType, String postTime) {
        switch (SourceType.valueOf(sourceType)) {
            case duowan:
                postTime = postTime.replace("上传于", "").trim();
                return DateUtil.getDateFromYDMHM(postTime);
            case web_78g:
                postTime = postTime.replace("时间：", "").trim();
                return DateUtil.getDateFromYDMHMS(postTime);
            case yxdown:
                return DateUtil.getDateFromYDMHMS(postTime);
        }
        return null;
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


    public void saveDuowanVideo(SpiderVideo video) {

    }

}
