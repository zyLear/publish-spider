package com.zylear.publish.spider.robot.web87g.processor;

import com.zylear.publish.spider.robot.bean.SpiderArticle;
import com.zylear.publish.spider.robot.web87g.pipeline.Web87GVideoPipeline;
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
 * Created by xiezongyu on 2018/8/7.
 */
@Component
public class Web87GVideoProcessor implements PageProcessor {

    private String itemListRegrex = "http://www\\.87g\\.com/pg/shipin/index_\\d+\\.html|http://www\\.87g\\.com/pg/shipin/";
    private Pattern pattern = Pattern.compile(itemListRegrex);


    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        Matcher matcher = pattern.matcher(page.getUrl().toString());
        if (matcher.matches()) {

            List<String> all = page.getHtml().xpath("//ul[@class='ul-news']//div[@class='txt']/h4/a/@href").all();
            List<String> list = page.getHtml().links().regex(".*//www.87g.com/pg/shipin/index_\\d+\\.html").all();
            page.addTargetRequests(all);
            page.addTargetRequests(list);
            page.getResultItems().setSkip(true);
        } else {
            Selectable selectable = page.getHtml().xpath("//link[@rel='stylesheet']");
            String title = page.getHtml().xpath("//div[contains(@class,'news-cont') or contains(@class,'m-article')]/h1/text()").toString();

            StringBuilder css = new StringBuilder("");
            for (Selectable node : selectable.nodes()) {
                css.append(node);
            }
            String postTime = page.getHtml().xpath("//div[@class='m-article']/div[@class='info']/span[1]/text()").toString();
            String content = page.getHtml().xpath("//div[contains(@class,'news-cont') or contains(@class,'m-article')]//div[contains(@class,'news-content') or contains(@class,'cont')]").toString();
            SpiderArticle article = new SpiderArticle(title, content, css.toString(), page.getUrl().toString());
            page.putField("article", article);

        }
// //
    }

    public static void main(String[] args) {
        Spider.create(new Web87GVideoProcessor()).addPipeline(new Web87GVideoPipeline()).addUrl("http://www.87g.com/pg/shipin/").run();

    }

}
