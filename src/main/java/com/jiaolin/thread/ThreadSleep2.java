package com.jiaolin.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

// 模拟倒计时和打印当前时间
public class ThreadSleep2 {

    private int num = 10;

    // 模拟当前时间
    public void testDown() throws InterruptedException {
        while (true) {
            if (num <= 0) {
                break;
            }
            Thread.sleep(1000);

            System.out.println(num--);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSleep2 threadSleep2 = new ThreadSleep2();
//        threadSleep2.testDown();

        threadSleep2.printDownData();
    }

    // 打印倒计时
    public void printDownData() {

        Date date = new Date();
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                date = new Date();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
