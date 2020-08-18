package com.example.demo.service;

import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Log
public class NewsCrawlService {
    @Autowired
    NewsRepository newsRepository;

    @Autowired
    HomeNewsRepository homeNewsRepository;

    private Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    public List<News> newsFindAll() {
        log.info("newsFindAll()");

        return newsRepository.findAll();
    }

    public List<HomeNews> homeNewsFindAll() {
        log.info("homeNewsFindAll()");

        return homeNewsRepository.findAll();
    }

    public void crawlingHome() {
        log.info("crawlingHome()");

        homeNewsRepository.deleteAll();
        document = connectUrl("https://news.daum.net/");

        Elements total = document.select("strong.tit_thumb>a.link_txt");
        Elements image = document.select("div.item_issue>a.link_thumb>img.thumb_g");

        HomeNews homeNews = null;

        for (int i = 0; i < total.size(); i++) {
            homeNews = new HomeNews();
            homeNews.setHomeNewsNo(String.valueOf(i + 1));
            homeNews.setTitle(total.get(i).text());
            homeNews.setAddress(total.get(i).attr("href"));
            homeNews.setImage(image.get(i).attr("src"));
            homeNewsRepository.save(homeNews);
        }
    }
}
