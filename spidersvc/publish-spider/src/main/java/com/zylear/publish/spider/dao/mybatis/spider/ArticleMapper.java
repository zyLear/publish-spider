package com.zylear.publish.spider.dao.mybatis.spider;

import com.zylear.publish.spider.domain.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);


    Article findBySourceTypeAndTitle(@Param("sourceType") Integer sourceType,
                                     @Param("title") String title);
}