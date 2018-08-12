package com.zylear.publish.spider.dao.mybatis.spider;

import com.zylear.publish.spider.domain.Video;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    Video findBySourceTypeAndTitle(@Param("sourceType") Integer sourceType,
                                     @Param("title") String title);

    List<Video> findNeedSubmitVideos();

    void updateAfterSubmit(
            @Param("id") Integer id,
            @Param("refId") Integer refId,
            @Param("submitTime") Date submitTime);
}