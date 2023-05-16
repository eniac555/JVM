package com.jvm;

/**
 * - 演示类加载过程中的初始化过程
 * - 如果初始化一个类的时候，其父类尚未初始化，则优先初始化其父类。
 * <p>
 * - 如果同时包含多个静态变量和静态代码块，则按照自上而下的顺序依次执行。
 */
public class A04Application {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello world");

        // 1. 首次访问这个类的静态变量或静态方法时
        //System.out.println(Animal.num);
        // 2. 子类初始化，如果父类还没初始化，会引发父类先初始化
        //System.out.println(Cat.sex);
        // 3. 子类访问父类静态变量，只触发父类初始化
        System.out.println(Cat.num);


       /* while (true) {
            Thread.sleep(1000);
            System.out.println("哈哈哈");
        }*/
    }


}

class Animal {
    static int num = 55;

    static {
        System.out.println("Animal 静态代码块...");
    }
}

class Cat extends Animal {
    static boolean sex = false;

    static {
        System.out.println("Cat 静态代码块...1");
    }

    static {
        System.out.println("Cat 静态代码块...2");
    }
}