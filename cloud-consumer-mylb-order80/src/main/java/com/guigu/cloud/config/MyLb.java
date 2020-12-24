package com.guigu.cloud.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb  {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    /**
     * 通过自旋方式获取下一个service类
     * 避免出现并发问题
     * */
    public ServiceInstance get(List<ServiceInstance> list){
        int count=0;
        int next=0;
        do {
            //防止数值越界(正常情况不会出现)
            count=this.atomicInteger.get()>2147483647?0:this.atomicInteger.get();
            next=(count+1) % list.size();
        }while (!this.atomicInteger.compareAndSet(count,next));
        return list.get(next);
    }


}
