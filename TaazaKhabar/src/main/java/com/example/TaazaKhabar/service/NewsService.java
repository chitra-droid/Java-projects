package com.example.TaazaKhabar.service;

import com.example.TaazaKhabar.response.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;


    public NewsResponse getNews(String country, String apikey) {

        String url = prepareUrl(country,apikey);
        return restTemplate.getForObject(url, NewsResponse.class);
    }

    public String prepareUrl(String country, String apikey){
        return "https://newsapi.org/v2/top-headlines?country="+ country +
                "&apikey="+apikey;
    }
}
