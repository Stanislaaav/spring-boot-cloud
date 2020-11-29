package com.iliev.zuulproxy.config;

import com.iliev.zuulproxy.filters.ProxyFilter;
import com.iliev.zuulproxy.filters.StartPreFilter;
import com.iliev.zuulproxy.filters.StopPostFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyFilterConfig {

    @Bean
    public ProxyFilter getProxyFilter() {
        return new ProxyFilter();
    }

    @Bean
    public StartPreFilter getStartPreFilter() {
        return new StartPreFilter();
    }

    @Bean
    public StopPostFilter getStopPostFilter() {
        return new StopPostFilter();
    }
}
