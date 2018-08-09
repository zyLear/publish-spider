package com.zylear.publish.spider.manager;

import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;
import com.zylear.publish.spider.manager.bean.PostBean;
import com.zylear.publish.spider.service.pubilsh.ArticleContentService;
import com.zylear.publish.spider.service.pubilsh.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by xiezongyu on 2018/8/8.
 */
@Component
public class SubmitManager {

    private ArticleService articleService;
    private ArticleContentService articleContentService;
    private PublishWebManager publishWebManager;

//    @PostConstruct
    public void submit() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                submitArticle();
            }
        }).start();
    }

    private void submitArticle() {
        List<Article> articles = articleService.findAll();
        for (Article article : articles) {

            ArticleContentWithBLOBs articleContent = articleContentService.selectByPrimaryKey(article.getContentId());
            if (articleContent == null) {
                continue;
            }

            PostBean postBean = new PostBean();

            postBean.setSourceType(article.getSourceType());
            postBean.setTitle(article.getTitle());
            postBean.setSpiderCategory(article.getSpiderCategory());
            postBean.setSourceUrl(article.getSourceUrl());
            postBean.setCss(articleContent.getCss());
            postBean.setContent(articleContent.getContent());
            publishWebManager.postArticle(postBean);
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
}
