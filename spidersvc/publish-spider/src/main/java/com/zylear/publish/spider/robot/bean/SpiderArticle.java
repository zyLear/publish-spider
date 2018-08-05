package com.zylear.publish.spider.robot.bean;

/**
 * Created by xiezongyu on 2018/8/5.
 */
public class SpiderArticle {
    public SpiderArticle() {
    }

    public SpiderArticle(String title, String content, String css,String sourceUrl) {
        this.title = title;
        this.content = content;
        this.css = css;
        this.sourceUrl = sourceUrl;
    }

    private String title;
    private String content;
    private String css;
    private String sourceUrl;

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
