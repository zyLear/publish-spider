package com.zylear.publish.spider.robot.web87g.processor;

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
 * Created by xiezongyu on 2018/8/5.
 */
@Component
public class Web87GProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(5000);
    private String itemListRegrex = "http://www\\.87g\\.com/pg/gonglue/index_\\d+\\.html|http://www\\.87g\\.com/pg/gonglue/";
    private Pattern pattern = Pattern.compile(itemListRegrex);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
//        GithubRepoPageProcessor
        Matcher matcher = pattern.matcher(page.getUrl().toString());
        if (matcher.matches()) {
//            page.getHtml().xpath("//ul[@class='ul-news']//div[@class='item']//div[@class='txt']/a").toString()
            List<String> all = page.getHtml().links().regex(".*//www.87g.com/pg/\\d+\\.html").all();
            List<String> list = page.getHtml().links().regex(".*//www.87g.com/pg/gonglue/index_\\d+\\.html").all();
            page.addTargetRequests(all);
            page.addTargetRequests(list);
            page.getResultItems().setSkip(true);
        } else {
//            System.out.println(page.getHtml().getDocument().toString());
            Selectable selectable = page.getHtml().xpath("//link[@rel='stylesheet']");
            String title = page.getHtml().xpath("//div[@class='m-article']/h1/text()").toString();

            StringBuilder css = new StringBuilder("");
            for (Selectable node : selectable.nodes()) {
                css.append(node);
            }
//            System.out.println("css :" + css);
            String content = page.getHtml().xpath("//div[@class='m-article']/div[@class='cont']").toString();
//            System.out.println("show s content:" + xpath);
            SpiderArticle article = new SpiderArticle(title, content, css.toString(), page.getUrl().toString());
            page.putField("article", article);

        }

    }

    public static void main(String[] args) {
        Spider.create(new Web87GProcessor()).addUrl("http://www.87g.com/pg/gonglue/").run();

    }


}
