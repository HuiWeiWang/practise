package com.huiwei.design.filter;

public class FilterImpl3 implements Filter{
    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("������3ִ��ǰ");
        chain.execute();
        System.out.println("������3ִ�к�");
    }

}
