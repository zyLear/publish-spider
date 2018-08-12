package com.zylear.publish.spider.service.pubilsh;

import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.domain.Video;

import java.util.Date;
import java.util.List;

/**
 * Created by xiezongyu on 2018/8/7.
 */
public interface VideoService {
    Video findBySourceTypeAndTitle(Integer value, String title);

    void insert(Video video);

    List<Video> findNeedSubmitVideos();

    void updateAfterSubmit(Integer id, Integer refId, Date date);
}
