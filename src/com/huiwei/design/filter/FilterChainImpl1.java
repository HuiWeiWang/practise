package com.huiwei.design.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChainImpl1 implements FilterChain{
    List<Filter> listfilter = new ArrayList<Filter>();
    private int index = 0;
    public void append(Filter filter){
        listfilter.add(filter);
    }
   private boolean execute_target = false;
    @Override
    public void execute() {
        if(index<listfilter.size()){
            Filter filter = listfilter.get(index);
            index++;
            filter.doFilter(this);
        }
        if(index==listfilter.size()){
            if(execute_target == false){
                execute_target = true;
                System.out.println("执行拦截目标的方法");
            }
        }
    }

}
