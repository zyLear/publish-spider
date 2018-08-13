package com.zylear.publish.spider.manager;

import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;
import com.zylear.publish.spider.domain.Video;
import com.zylear.publish.spider.enums.VideoType;
import com.zylear.publish.spider.manager.bean.ArticlePostBean;
import com.zylear.publish.spider.manager.bean.VideoPostBean;
import com.zylear.publish.spider.service.pubilsh.ArticleContentService;
import com.zylear.publish.spider.service.pubilsh.ArticleService;
import com.zylear.publish.spider.service.pubilsh.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by xiezongyu on 2018/8/8.
 */
@Component
public class SubmitManager {

    private ArticleService articleService;
    private ArticleContentService articleContentService;
    private PublishWebManager publishWebManager;
    private VideoService videoService;

    public void submitArticle() {
        List<Article> articles = articleService.findAll();
        for (Article article : articles) {

            ArticleContentWithBLOBs articleContent = articleContentService.selectByPrimaryKey(article.getContentId());
            if (articleContent == null) {
                continue;
            }

            ArticlePostBean articlePostBean = new ArticlePostBean();

            articlePostBean.setSourceType(article.getSourceType());
            articlePostBean.setTitle(article.getTitle());
            articlePostBean.setSpiderCategory(article.getSpiderCategory());
            articlePostBean.setSourceUrl(article.getSourceUrl());
            articlePostBean.setCss(articleContent.getCss());
            Date postTime = article.getPostTime();
            if (postTime == null) {
                articlePostBean.setPostTime(0L);
            } else {
                articlePostBean.setPostTime(article.getPostTime().getTime());
            }

            articlePostBean.setContent(articleContent.getContent());
            Integer refId = publishWebManager.submitArticle(articlePostBean);
            if (refId != -1) {
                articleService.updateAfterSubmit(article.getId(), refId, new Date());
            }
        }
    }

    public void submitVideo() {
        List<Video> videos = videoService.findNeedSubmitVideos();
        for (Video video : videos) {
            ArticleContentWithBLOBs articleContent = null;
            if (VideoType.content_html.getValue().equals(video.getVideoType())) {
                articleContent = articleContentService.selectByPrimaryKey(video.getContentId());
                if (articleContent == null) {
                    continue;
                }
            }
            VideoPostBean videoPostBean = new VideoPostBean();
            videoPostBean.setSourceType(video.getSourceType());
            videoPostBean.setTitle(video.getTitle());
            videoPostBean.setVideoCategory(video.getVideoCategory());
            videoPostBean.setPostTime(video.getPostTime().getTime());
            videoPostBean.setSourceUrl(video.getSourceUrl());
            videoPostBean.setCoverImgUrl(video.getCoverImgUrl());
            videoPostBean.setFlashvars(video.getFlashvars());
            videoPostBean.setVideoType(video.getVideoType());
            videoPostBean.setVideoSource(video.getVideoSource());
            if (articleContent != null) {
                videoPostBean.setCss(articleContent.getCss());
                videoPostBean.setContent(articleContent.getContent());
            }

            Integer refId = publishWebManager.submitVideo(videoPostBean);
            if (refId != -1) {
                videoService.updateAfterSubmit(video.getId(), refId, new Date());
            }

        }
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
    public void setPublishWebManager(PublishWebManager publishWebManager) {
        this.publishWebManager = publishWebManager;
    }

    @Autowired
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }
}
