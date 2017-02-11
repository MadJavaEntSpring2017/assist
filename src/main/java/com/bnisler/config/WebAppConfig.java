package com.bnisler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Ben on 2/11/2017.
 */
@Configuration
@ComponentScan({"com.bnisler"})
public class WebAppConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("WEB-INF");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
