package com.zylear.publish.spider.robot.yxdown.processor;

import com.zylear.publish.spider.robot.bean.SpiderArticle;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiezongyu on 2018/8/8.
 */
@Component
public class YxdownPubgArticleProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);
    private String itemListRegrex = "http://www\\.yxdown\\.com/z/jdqscjzcsy/gl/|http://www.yxdown.com/z/jdqscjzcsy/gl/\\d+/";
    private Pattern pattern = Pattern.compile(itemListRegrex);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {

        Matcher matcher = pattern.matcher(page.getUrl().toString());
        if (matcher.matches()) {
            List<String> all = page.getHtml().xpath("//div[@class='cbox']/div[@class='list_L']/ul/li//a/@href").all();
            List<String> list = page.getHtml().links().regex(".*//www\\.yxdown\\.com/z/jdqscjzcsy/gl/\\d+/").all();
            page.addTargetRequests(all);
            page.addTargetRequests(list);
            page.getResultItems().setSkip(true);
        } else {

            Selectable selectable = page.getHtml().xpath("//link[@rel='stylesheet']");
            StringBuilder css = new StringBuilder("");
            for (Selectable node : selectable.nodes()) {
                css.append(node);
            }
            String title = page.getHtml().xpath("//div[@class='news_l']/div[@class='news']/h1/text()").toString();

            String content = page.getHtml().xpath("//div[@id='content']").toString();
            String postTime = page.getHtml().xpath("//div[@class='news_l']/div[@class='news']/div[@class='intro']/span[1]/text()").toString();
            SpiderArticle article = new SpiderArticle(title, content, css.toString(), page.getUrl().toString(), postTime);
            page.putField("article", article);

        }
    }

    public static void main(String[] args) {
        Spider.create(new YxdownPubgArticleProcessor()).addUrl("http://www.yxdown.com/z/jdqscjzcsy/gl/").run();
    }

}
