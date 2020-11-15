package com.huiwei.design.filter;

public class FilterImpl1 implements Filter{
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("过滤器1执行前");
        chain.execute();
        System.out.println("过滤器1执行后");
    }
}
