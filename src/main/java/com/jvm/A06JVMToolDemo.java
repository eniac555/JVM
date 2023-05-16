package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于测试jvm调优工具的demo
 */
public class A06JVMToolDemo {

    public static void main(String[] args) {
        new Thread(()->{
            while (true){

            }
        },"t1").start();
        new Thread(()->{
            while (true){

            }
        },"t2").start();
        new Thread(()->{
            while (true){

            }
        },"t3").start();

        List<String> list = new ArrayList<>();
        while (true){
            list.add("北京");
        }
    }
}
