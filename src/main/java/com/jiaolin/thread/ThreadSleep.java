package com.jiaolin.thread;

// 网络延迟抢票问题
public class ThreadSleep implements Runnable {

    private int ticket = 10;

    public void run() {

        while (true) {
            if (ticket <= 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到第" + ticket-- + "票");
        }

    }

    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();
        new Thread(threadSleep, "zs").start();
        new Thread(threadSleep, "ls").start();
        new Thread(threadSleep, "ww").start();
    }
}
