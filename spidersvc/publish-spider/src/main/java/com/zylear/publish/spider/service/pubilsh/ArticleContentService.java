package com.zylear.publish.spider.service.pubilsh;

import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;

/**
 * Created by xiezongyu on 2018/8/5.
 */
public interface ArticleContentService {
    ArticleContentWithBLOBs selectByPrimaryKey(Integer contentId);

    void insert(ArticleContentWithBLOBs articleContent);
}
