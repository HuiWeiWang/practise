package com.huiwei.design.filter;

public class FilterImpl1 implements Filter{
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("������1ִ��ǰ");
        chain.execute();
        System.out.println("������1ִ�к�");
    }
}
