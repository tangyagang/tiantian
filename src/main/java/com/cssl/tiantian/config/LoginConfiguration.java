package com.cssl.tiantian.config;

import com.cssl.tiantian.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;


@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    //    以下WebMvcConfigurerAdapter 比较常用的重写接口
//    /** 解决跨域问题 **/
//    public void addCorsMappings(CorsRegistry registry) ;
//    /** 添加拦截器 **/
//    void addInterceptors(InterceptorRegistry registry);
//    /** 这里配置视图解析器 **/
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    void configureViewResolvers(ViewResolverRegistry registry);
//    /** 配置内容裁决的一些选项 **/
//    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//    /** 静态资源处理 **/
//    void addResourceHandlers(ResourceHandlerRegistry registry);
//    /** 默认静态资源处理器 **/
//    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);

    @Resource
    private LoginInterceptor loginInterceptor;

    public void addViewControllers(ViewControllerRegistry registry) {
        //自定义定义路径映射
        registry.addViewController("/").setViewName("/login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/userManager/**","/adminManager/**","/superManager/**")
                .excludePathPatterns("/index","/login","/doLogin")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/**/*.jpg","/**/*.png","/**/*.gpeg","/**/*.gif")
                .excludePathPatterns("/**/*.js","/**/*.css");
    }

    /**
     * 配置静态资源,避免静态资源请求被拦截
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


}
