package com.jiaolin.thread;

// 实现runnable接口
public class ThreadTest2 implements Runnable{

    public static void main(String[] args) {

        ThreadTest2 threadTest2= new ThreadTest2();

        new Thread(threadTest2).start();

        for (int i = 0; i < 200; i++) {
            // 向上移动 command+⬆️ +⬆上
            System.out.println("我在看小说,我在看小说,我在看小说: "+i);
        }
    }

    public void run() {
        for (int i = 0; i < 200; i++) {
            // 向上移动 command+⬆️ +⬆上
            System.out.println("我在撸代码: "+i);
        }
    }
}
