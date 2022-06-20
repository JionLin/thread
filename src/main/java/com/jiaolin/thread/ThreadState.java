package com.jiaolin.thread;

// 线程的状态
public class ThreadState  {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("======");
            }
        });


        Thread.State state = thread.getState();
        System.out.println("线程的状态1是：" + state);

        thread.start();
        state = thread.getState();
        System.out.println("线程的状态2是" + state);

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            System.out.println("线程的状态3是" + state);
            state = thread.getState();
        }


    }


}
