package com.zylear.publish.spider.dao.mybatis.publish;

import com.zylear.publish.spider.domain.OwnBlog;

public interface OwnBlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OwnBlog record);

    int insertSelective(OwnBlog record);

    OwnBlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OwnBlog record);

    int updateByPrimaryKeyWithBLOBs(OwnBlog record);

    int updateByPrimaryKey(OwnBlog record);
}