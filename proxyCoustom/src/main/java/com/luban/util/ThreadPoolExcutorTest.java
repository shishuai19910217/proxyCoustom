package com.luban.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author EDZ
 * @date 2020/09/03
 **/
public class ThreadPoolExcutorTest {
    public static void main(String[] args) {
        ThreadPoolExcutorTest test = new ThreadPoolExcutorTest();
        test.test();
    }
    private  void  test() {
        ThreadFactory factory = new MyThreadFactroy("创建线程");
        Executor executor = new ThreadPoolExecutor(3,6,30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(11),factory);
        for (int i=0 ;i<20;i++){
            executor.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }

    class  MyThreadFactroy implements ThreadFactory{

        private final String namePrefix;
        private final AtomicInteger nextId = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            String name = namePrefix + nextId.getAndIncrement();
            Thread thread = new Thread(runnable, name);
            return thread;
        }
        public MyThreadFactroy(String featureOfGroup){
            namePrefix = featureOfGroup + ",线程编号：";
        }
    }
}
