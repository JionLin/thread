package com.jiaolin.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 不安全的买票
public class UnSafeBuyTicket {


    // 有10张票 3个人同时买

    public static void main(String[] args) {
        BuyTicket unSafeBuyTicket = new BuyTicket();

        Thread thread = new Thread(unSafeBuyTicket, "A");
        Thread thread1 = new Thread(unSafeBuyTicket, "B");
        Thread thread2 = new Thread(unSafeBuyTicket, "C");

        thread.start();
        thread1.start();
        thread2.start();

    }


}

class BuyTicket implements Runnable {


    private boolean flag = true;

    private int ticket = 10;

    public void run() {
        while (flag) {
            buy();
        }
    }

    private final ReentrantLock lock = new ReentrantLock();

    public void buy() {
        lock.lock();
        try {
            if (ticket <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获取的票是" + ticket-- + "张");

        } finally {
            lock.unlock();
        }

    }
}

