package com.cssl.tiantian.config;

import com.cssl.tiantian.converter.DateConverter;
import com.cssl.tiantian.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MvcConfigurer implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        /*该方法的参数ViewResolverRegistry 是一个注册器，用来注册你想自定义的视图解析器等*/
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".ftl");
        resolver.setRequestContextAttribute("request");
        registry.viewResolver(resolver);
    }
    /**
     * 配置全局日期转换器
     */
    @Bean
    @Autowired
    public ConversionService getConversionService(DateConverter dateConverter){
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<Converter>();
        converters.add(dateConverter);
        factoryBean.setConverters(converters);
        return factoryBean.getObject();
    }

    //添加文件上传的自动映射路径
   @Value("${file.staticAccessPath}")
   private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
    }

}
