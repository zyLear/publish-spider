package com.zylear.publish.spider.service.pubilsh.impl;

import com.zylear.publish.spider.dao.mybatis.spider.ArticleContentMapper;
import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;
import com.zylear.publish.spider.service.pubilsh.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xiezongyu on 2018/8/5.
 */
@Component
public class ArticleContentServiceImpl implements ArticleContentService {

    @Autowired
    private ArticleContentMapper articleContentMapper;

    @Override
    public ArticleContentWithBLOBs selectByPrimaryKey(Integer contentId) {
        return articleContentMapper.selectByPrimaryKey(contentId);
    }

    @Override
    public void insert(ArticleContentWithBLOBs articleContent) {
        articleContentMapper.insert(articleContent);
    }
}
