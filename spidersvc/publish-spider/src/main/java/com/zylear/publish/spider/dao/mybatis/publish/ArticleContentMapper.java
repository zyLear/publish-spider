package com.zylear.publish.spider.dao.mybatis.publish;

import com.zylear.publish.spider.domain.ArticleContent;
import com.zylear.publish.spider.domain.ArticleContentWithBLOBs;

public interface ArticleContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContentWithBLOBs record);

    int insertSelective(ArticleContentWithBLOBs record);

    ArticleContentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleContentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleContentWithBLOBs record);

    int updateByPrimaryKey(ArticleContent record);
}