package com.jiaolin.thread;

// 主线程
public class JoinThread implements Runnable {

    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("线程VIP 来了" + i);

        }

    }

    public static void main(String[] args) throws InterruptedException {
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            if (i == 100) {
                thread.join();
            }
            System.out.println("main "+i);

        }
    }
}
