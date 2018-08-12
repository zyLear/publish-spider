package com.zylear.publish.spider.enums;

/**
 * Created by xiezongyu on 2018/8/7.
 */
public enum VideoType {

    unknown(-1),
    source_url(1),
    iframe(2),
    content_html(3),
    embed(4)
    ;


    VideoType(Integer value) {
        this.value = value;
    }

    private Integer value;


    public Integer getValue() {
        return value;
    }

}
