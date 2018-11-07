package com.zyb.basic.classloader;

/**
 * @Title: ClassLoaderTest.java
 * @Package com.zyb.basic.classloader
 * @Description: TODO
 * @Author ZhangYB
 * @Version V1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
