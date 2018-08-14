package com.zylear.publish.spider.robot.duowan.processor;

import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.robot.bean.SpiderVideo;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiezongyu on 2018/8/8.
 */
@Component
public class DuowanVideoProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);
    private String itemListRegrex = "http://video\\.duowan\\.com/lol/yule_\\d\\.html|http://video\\.duowan\\.com/lol/yule\\.html";
    private Pattern pattern = Pattern.compile(itemListRegrex);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {

        Matcher matcher = pattern.matcher(page.getUrl().toString());
        if (matcher.matches()) {
            List<Selectable> all = page.getHtml().xpath("//div[@class='m-newsbox__bd']//div[@class='uiVideo__item']/a[1]").nodes();
            for (Selectable selectable : all) {
                String url = selectable.xpath("/a/@href").toString();
                url = url.replace("play", "vplay");
                Request request = new Request(url);
                HashMap<String, Object> map = new HashMap<>(1);
                String coverImgUrl = selectable.xpath("/a/img/@src").toString();
                map.put("coverImgUrl", coverImgUrl);
                request.setExtras(map);
                page.addTargetRequest(request);
            }
            List<String> list = page.getHtml().links().regex(".*//video\\.duowan\\.com/lol/yule_\\d\\.html").all();
            page.addTargetRequests(list);
            page.getResultItems().setSkip(true);
        } else {
            String title = page.getHtml().xpath("//div[@class='play-cont-l fltL']/h1[@class='play-title']/text()").toString();
            String coverImgUrl = page.getRequest().getExtra("coverImgUrl").toString();
            String videoSource = page.getHtml().xpath("//div[@id='video_embed']/embed/@src").toString();
            String flashvars = page.getHtml().xpath("//div[@id='video_embed']/embed/@flashvars").toString();
            String postTime = page.getHtml().xpath("//div[@class='author-top']/span[@class='update-time']/text()").toString();
            SpiderVideo video = new SpiderVideo(title, null, null, page.getUrl().toString(), postTime, coverImgUrl, videoSource, flashvars);
            page.putField("video", video);

        }
    }

    public static void main(String[] args) {
        Spider.create(new DuowanVideoProcessor()).addUrl("http://video.duowan.com/lol/yule.html").run();
    }

}


//    String title = page.getHtml().xpath("//div[@id='dw-video-wrap']/div[1]//div[@class='vcol-main-hd']/h1/text()").toString();
//
//    String coverImgUrl = page.getHtml().xpath("//div[@id='dw-video-wrap']/div[1]//div[@class='dw-video-main']//video/@poster").toString();
//    String videoSource = page.getHtml().xpath("//div[@id='dw-video-wrap']/div[1]//div[@class='dw-video-main']//video/@src").toString();
//    String postTime = page.getHtml().xpath("//div[@id='dw-video-wrap']/div[1]//div[@class='vcol-main-hd']/em/text()").toString();