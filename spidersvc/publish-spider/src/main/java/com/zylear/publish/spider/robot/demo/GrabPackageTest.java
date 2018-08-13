package com.zylear.publish.spider.robot.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by xiezongyu on 2018/8/11.
 */
public class GrabPackageTest {

    public static void main(String[] args) throws IOException {
//        Document document = Jsoup.connect("http://video.duowan.com/play/8935807.html").get();
        Document document = Jsoup.connect("http://video.duowan.com/lol/yule.html").get();

     //   http://video.duowan.com/vplay/8935807.html?vfrom=oldweb
        System.out.println(document);
    }

}
