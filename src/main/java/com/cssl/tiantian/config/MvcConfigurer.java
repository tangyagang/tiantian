package com.cssl.tiantian.config;

import com.cssl.tiantian.converter.DateConverter;
import com.cssl.tiantian.interceptors.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashSet;
import java.util.Set;

@Component
public class MvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor myInterceptor = new MyInterceptor();
        registry.addInterceptor(myInterceptor);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        /*该方法的参数ViewResolverRegistry 是一个注册器，用来注册你想自定义的视图解析器等*/
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".ftl");
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
}
