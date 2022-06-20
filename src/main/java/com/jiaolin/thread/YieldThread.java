package com.jiaolin.thread;

// 礼让线程  让当前执行的线程暂停
public class YieldThread implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行了");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束了");
    }


    public static void main(String[] args) {
        YieldThread yieldThread=new YieldThread();

        new Thread(yieldThread,"A").start();
        new Thread(yieldThread,"B").start();
    }
}
