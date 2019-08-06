package com.demo.config;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Pattern;

/**
 * @Author Mcorleon
 * @Date 2019/6/27 14:42
 */
public class MyCrawler extends WebCrawler {
    //过滤非html后缀
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        //这个方法的作用是过滤不想访问的url
        //return false时  url被过滤掉不会被爬取
        String href = url.getURL().toLowerCase();//爬取的网址 转小写
        //这里定义过滤的网址，我的需求是只爬取京东搜索出来的页面中的商品，url需要以https://search.jd.com/search开头
        boolean b = !FILTERS.matcher(href).matches() && href.startsWith("http://search.dangdang.com/?key");
        return b;
    }

    @Override
    public void visit(Page page) {
        //这个方法的作用是当shouldVisit方法返回true时，调用该方法，获取网页内容，已被封装到Page对象中
        String url = page.getWebURL().getURL();
        System.out.println(url);
        //判断page是否为真正的网页
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();//页面html内容
            Document doc = Jsoup.parse(html);//采用jsoup解析html，这个大家不会可以简单搜一下

            //使用选择器的时候需要了解网页中的html规则，去网页中F12一下，
            Elements elements = doc.select("li[ddt-pit]");
            if (elements.size() == 0) {
                return;
            }
            for (Element element : elements) {
                Elements detail = element.select("a[title]");
                if (detail != null) {
                    //输出图片链接
                    System.out.println(detail.attr("title"));
                }
            }
        }

    }

}
