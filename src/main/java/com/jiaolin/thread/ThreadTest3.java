package com.jiaolin.thread;

import java.util.concurrent.*;

// 实现runnable接口
public class ThreadTest3 implements Callable<Boolean> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest3 t1 = new ThreadTest3();
        ThreadTest3 t2 = new ThreadTest3();
        ThreadTest3 t3 = new ThreadTest3();

        // 创建执行服务
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // 执行请求
        Future<Boolean> submit = threadPool.submit(t1);
        Future<Boolean> submit1 = threadPool.submit(t2);
        Future<Boolean> submit2 = threadPool.submit(t3);
        // 获取结果
        System.out.println(submit.get());
        System.out.println(submit1.get());
        System.out.println(submit2.get());

        // 关闭服务
        threadPool.shutdown();


    }


    public Boolean call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"在撸代码: "+i);
        }
        return true;
    }
}
