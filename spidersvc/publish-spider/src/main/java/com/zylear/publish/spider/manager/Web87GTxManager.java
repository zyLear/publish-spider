package com.zylear.publish.spider.manager;

import com.zylear.publish.spider.config.DataSourcePublishConfig;
import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;
import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.service.pubilsh.ArticleContentService;
import com.zylear.publish.spider.service.pubilsh.ArticleService;
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

    @Transactional(DataSourcePublishConfig.TX_MANAGER)
    public void saveArticle(SpiderArticle spiderArticle) {

        Article exist = articleService.findBySourceTypeAndTitle(1, spiderArticle.getTitle());

        if (exist != null) {
            logger.info("article exist. sourceType:{} title:{}", 1, spiderArticle.getTitle());
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

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setArticleContentService(ArticleContentService articleContentService) {
        this.articleContentService = articleContentService;
    }
}
