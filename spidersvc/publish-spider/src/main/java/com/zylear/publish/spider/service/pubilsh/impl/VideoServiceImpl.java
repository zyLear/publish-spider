package com.zylear.publish.spider.service.pubilsh.impl;

import com.zylear.publish.spider.dao.mybatis.spider.VideoMapper;
import com.zylear.publish.spider.domain.Article;
import com.zylear.publish.spider.domain.Video;
import com.zylear.publish.spider.service.pubilsh.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by xiezongyu on 2018/8/7.
 */
@Component
public class VideoServiceImpl implements VideoService {
    private VideoMapper videoMapper;


    @Override
    public Video findBySourceTypeAndTitle(Integer value, String title) {
        return videoMapper.findBySourceTypeAndTitle(value,title);
    }

    @Override
    public void insert(Video video) {
        videoMapper.insert(video);
    }

    @Override
    public List<Video> findNeedSubmitVideos() {
        return videoMapper.findNeedSubmitVideos();
    }

    @Override
    public void updateAfterSubmit(Integer id, Integer refId, Date date) {
        videoMapper.updateAfterSubmit(id, refId, date);
    }

    @Autowired
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }


}
