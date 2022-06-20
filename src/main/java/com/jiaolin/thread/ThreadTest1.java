package com.jiaolin.thread;

// 继承Thread类,重写run方法
public class ThreadTest1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            // 向上移动 command+⬆️ +⬆上
            System.out.println("我在撸代码: "+i);
        }
    }

    public static void main(String[] args) {

        new ThreadTest1().start();

        for (int i = 0; i < 200; i++) {
            // 向上移动 command+⬆️ +⬆上
            System.out.println("我在看小说,我在看小说,我在看小说: "+i);
        }
    }
}
