package com.jiaolin.thread;

// 线程停止 建议使用标志位
public class ThreadStop implements Runnable {


    private boolean flag = true;

    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("sub thread,sub thread,sub thread " + i++ + "个");
        }
    }

    private void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();
        new Thread(threadStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main thread"+i);
            if (i == 900) {
                // 切换标志位
                threadStop.stop();
                System.out.println("该线程停止了");

            }
        }


    }
}
