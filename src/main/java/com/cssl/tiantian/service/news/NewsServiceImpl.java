package com.cssl.tiantian.service.news;

import com.cssl.tiantian.dao.news.NewsMapper;
import com.cssl.tiantian.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getAll() {
        return newsMapper.getAllNews();
    }
}
