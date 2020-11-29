package com.iliev.zuulproxy.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ProxyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        boolean isMobile = false;
        RequestContext ctx = RequestContext.getCurrentContext();
        if (ctx != null) {
            isMobile = true;
        }
        return isMobile;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("caling a filter");
        return null;
    }
}
