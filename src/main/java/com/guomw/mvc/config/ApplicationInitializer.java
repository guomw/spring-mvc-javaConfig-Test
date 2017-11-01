package com.guomw.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    /**
     * 配置dispatcher servlet，如果在root config指定了该转发规则就可以忽略
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }


    /**
     * 指定开始被servlet处理的url,配置从/开始
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置servlet过滤器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }
}
