package com.demo.controller;

import com.demo.config.MyCrawler;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.stereotype.Controller;

/**
 * @Author Mcorleon
 * @Date 2019/6/27 14:44
 */

public class CrawlerController {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "/data/crawl/root";//文件存储位置
        int numberOfCrawlers = 1;//线程数量

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);//配置对象设置

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);//创建

        controller.addSeed("http://search.dangdang.com/?key=衣服&act=input");//传入的url

        controller.start(MyCrawler.class, numberOfCrawlers);//开始执行爬虫
    }

}
