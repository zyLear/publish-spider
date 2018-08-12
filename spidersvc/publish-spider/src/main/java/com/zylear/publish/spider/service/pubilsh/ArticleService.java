package com.zylear.publish.spider.service.pubilsh;

import com.zylear.publish.spider.domain.Article;

import java.util.Date;
import java.util.List;

/**
 * Created by xiezongyu on 2018/8/5.
 */
public interface ArticleService {
    Article selectByPrimaryKey(Integer id);

    void insert(Article article);

    Article findBySourceTypeAndTitle(Integer sourceType, String title);

    List<Article> findAll();

    void updateAfterSubmit(Integer id, Integer refId, Date date);
}
