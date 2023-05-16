package com.jvm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示元空间内存溢出 java.lang.OutOfMemoryError: Metaspace
 * -XX:MaxMetaspaceSize=8m--运行配置里加
 * 元空间默认大小没有上限
 */
public class A01MetaspaceDemo extends ClassLoader { // 可以用来加载类的二进制字节码
    public static void main(String[] args) {
        A01MetaspaceDemo test = new A01MetaspaceDemo();
        for (int i = 0; i < 10000; i++) {
            // ClassWriter 作用是生成类的二进制字节码
            ClassWriter cw = new ClassWriter(0);
            // jdk版本号， 类的修饰符public， 类名, 包名, 父类， 接口
            cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i,
                    null, "java/lang/Object", null);
            // 返回 byte[]
            byte[] code = cw.toByteArray();
            // 执行了类的加载
            test.defineClass("Class" + i, code, 0, code.length); // Class 对象
        }
    }
}
