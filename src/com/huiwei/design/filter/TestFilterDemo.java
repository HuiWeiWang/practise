package com.huiwei.design.filter;

public class TestFilterDemo {
    public static void main(String[] args) {
        FilterChainImpl1 chain = new FilterChainImpl1();
        chain.append(new FilterImpl1());
        chain.append(new FilterImpl2());
        chain.append(new FilterImpl3());
        chain.execute();
    }

}
