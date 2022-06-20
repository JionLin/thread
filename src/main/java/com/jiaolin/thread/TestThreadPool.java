package com.jiaolin.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 测试线程池 4 ok
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new MyThread2());
        executorService.submit(new MyThread2());
        executorService.submit(new MyThread2());
        executorService.submit(new MyThread2());

        executorService.shutdown();
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行了");
    }
}
