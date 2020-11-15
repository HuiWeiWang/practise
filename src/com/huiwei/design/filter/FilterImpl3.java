package com.huiwei.design.filter;

public class FilterImpl3 implements Filter{
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("过滤器3执行前");
        chain.execute();
        System.out.println("过滤器3执行后");
    }

}
