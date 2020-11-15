package com.huiwei.design.filter;

public class FilterImpl2 implements Filter {
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("过滤器2执行前");
        chain.execute();
        System.out.println("过滤器2执行后");
    }
}
