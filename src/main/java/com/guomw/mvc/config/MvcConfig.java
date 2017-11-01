package com.guomw.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.util.*;


@Configuration
@EnableWebMvc
@ComponentScan("com.guomw.mvc")
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 静态资源处理
     */
    private static String[] STATIC_RESOURCE_PATH = {
            "resources"
    };


    @Autowired
    private Environment environment;

    @Autowired
    private WebApplicationContext webApplicationContext;


    /**
     * 静态资源设置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        for (String resourcePath:STATIC_RESOURCE_PATH) {
            registry.addResourceHandler("/"+resourcePath+"/**").addResourceLocations("/"+resourcePath+"/");

        }
    }

    /**
     * 设置html视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //super.configureViewResolvers(registry);
        registry.viewResolver(thymeleafViewResolver());
    }

    /**
     * 设置异常处理
     * @param exceptionResolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.configureHandlerExceptionResolvers(exceptionResolvers);
       // exceptionResolvers.add(new WEb)
    }

    /**
     * thymeleaf 模版解析器
     * @return
     */
    private ViewResolver thymeleafViewResolver(){

        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setApplicationContext(webApplicationContext);
        templateResolver.setCharacterEncoding("utf-8");

        if (environment.acceptsProfiles("development"))
        {
            templateResolver.setCacheable(false);
        }

        SpringTemplateEngine engine=new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);

        ThymeleafViewResolver resolver=new ThymeleafViewResolver();
        resolver.setTemplateEngine(engine);
        resolver.setContentType("text/html;charset=utf-8");
        resolver.setCharacterEncoding("utf-8");
        resolver.setOrder(1);
        return resolver;

    }



}
