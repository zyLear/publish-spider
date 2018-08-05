package com.zylear.publish.spider.service.pubilsh;

import com.zylear.publish.spider.domain.OwnBlog;

/**
 * Created by xiezongyu on 2018/8/4.
 */
public interface OwnBlogService {

    OwnBlog selectByPrimaryKey(Integer blogId);

    void insert(String title, String content);
}
