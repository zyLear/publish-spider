package com.zylear.publish.spider.service.pubilsh.impl;

import com.zylear.publish.spider.dao.mybatis.spider.ArticleMapper;
import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.service.pubilsh.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xiezongyu on 2018/8/5.
 */
@Component
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleMapper articleMapper;

    @Override
    public Article selectByPrimaryKey(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(Article article) {
        articleMapper.insert(article);
    }

    @Override
    public Article findBySourceTypeAndTitle(Integer sourceType, String title) {
        return articleMapper.findBySourceTypeAndTitle(sourceType, title);
    }
}
