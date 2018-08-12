package com.zylear.publish.spider.robot.bean;

/**
 * Created by xiezongyu on 2018/8/5.
 */
public class SpiderArticle {
    public SpiderArticle() {
    }

    public SpiderArticle(String title, String content, String css, String sourceUrl, String postTime) {
        this.title = title;
        this.content = content;
        this.css = css;
        this.sourceUrl = sourceUrl;
        this.postTime = postTime;


    }

    public SpiderArticle(String title, String content, String css, String sourceUrl) {
        this.title = title;
        this.content = content;
        this.css = css;
        this.sourceUrl = sourceUrl;
    }

    private String title;
    private String content;
    private String css;
    private String sourceUrl;

    private String postTime;

//    private String coverImgUrl;
//    private String videoSource;

//    public SpiderArticle(String title,String css, String sourceUrl, String postTime, String coverImgUrl, String videoSource) {
//        this.title = title;
////        this.content = content;
//        this.css = css;
//        this.sourceUrl = sourceUrl;
//        this.postTime = postTime;
//        this.coverImgUrl = coverImgUrl;
//        this.videoSource = videoSource;
//    }

//    public String getCoverImgUrl() {
//        return coverImgUrl;
//    }
//
//    public void setCoverImgUrl(String coverImgUrl) {
//        this.coverImgUrl = coverImgUrl;
//    }
//
//    public String getVideoSource() {
//        return videoSource;
//    }
//
//    public void setVideoSource(String videoSource) {
//        this.videoSource = videoSource;
//    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        return "SpiderArticle{" +
                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", css='" + css + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                '}';
    }
}
