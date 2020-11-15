package com.huiwei.design.filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FilterChainImpl2 implements FilterChain{
    LinkedList<Filter> listfilter = new LinkedList<Filter>();
    public void append(Filter filter){
        listfilter.add(filter);
    }
    @Override
    public void execute() {
        if(hasNextFilter())
            nextFilter().doFilter(this);
        else{
            System.out.println("执行目标方法");
        }
    }
    public boolean hasNextFilter(){
        return listfilter.size() > 0;
    }
    public Filter nextFilter(){
        return listfilter.pop();
    }


}
