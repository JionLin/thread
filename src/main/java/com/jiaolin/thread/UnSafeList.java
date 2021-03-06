package com.jiaolin.thread;

import java.util.ArrayList;
import java.util.List;

// 不安全的集合
public class UnSafeList {
    public static void main(String[] args) {

         List<String> list=new ArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->list.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());

    }
}
