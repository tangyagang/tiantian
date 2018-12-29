package com.cssl.tiantian.controller;

import com.cssl.tiantian.pojo.News;
import com.cssl.tiantian.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller
public class NewsController {

   // @Autowired
    private NewsService newsService;

   /// @RequestMapping("/index")
    public String listNews(ModelMap modelMap){
        List<News> newsList = newsService.getAll();
        modelMap.put("newsList",newsList);
        return "newsList";
    }
}
