package com.cssl.tiantian.dao.news;

import com.cssl.tiantian.pojo.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    public List<News> getAllNews();
}
