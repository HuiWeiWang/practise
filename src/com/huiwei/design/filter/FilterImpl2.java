package com.huiwei.design.filter;

public class FilterImpl2 implements Filter {
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("������2ִ��ǰ");
        chain.execute();
        System.out.println("������2ִ�к�");
    }
}
