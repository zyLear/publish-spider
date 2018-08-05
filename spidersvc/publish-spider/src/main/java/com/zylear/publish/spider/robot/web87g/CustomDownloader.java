package com.zylear.publish.spider.robot.web87g;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;

/**
 * Created by xiezongyu on 2018/8/5.
 */
public class CustomDownloader implements Downloader {

    @Override
    public Page download(Request request, Task task) {
        return null;
    }

    @Override
    public void setThread(int threadNum) {

    }
}
