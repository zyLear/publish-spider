package com.zylear.publish.spider.domain;

public class ArticleContentWithBLOBs extends ArticleContent {
    private String css;

    private String content;

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}