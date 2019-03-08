package com.isoftstone.bi.feignserver.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: leo
 * @Date: 2019/2/12 17:30
 * @Version 0.0.1
 * @Desc 配置拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public AuthInterceptor getAuthInterceptor(){
        return new AuthInterceptor();
    }
}
