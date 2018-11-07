package com.zyb.test;

/**
 * @Title: StringTest.java
 * @Package com.zyb.test
 * @Description: TODO
 * @Author ZhangYB
 * @Date 2018-09-02 7:00
 * @Version V1.0
 */
public class StringTest {

    public static void main(String[] args) {

        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        //true
        System.err.println("i1 == i2" + (i1 == i2));
        //true
        System.err.println("i1 == i2 + i3" + (i1 == i2 + i3));
        //false
        System.err.println("i1 == i4" + (i1 == i4));
        //false
        System.err.println("i4 == i5" + (i4 == i5));
        //true
        System.err.println("i4 == i5 + i6" +(i4==i5 + i6));
        //true
        System.err.println("40 == i5 + i6 " + (40 == i5 + i6));

//        Integer i1 =  33;
//        Integer i2 =33;
//        //true
//        System.err.println(i1 == i2);
//
//        Integer i11 =  333;
//        Integer i22 =333;
//        //true
//        System.err.println(i11 == i22);
//
//        Double i3 = 1.2;
//        Double i4 = 1.2;
//        //false
//        System.err.println(i3 == i4);
//
//        Integer i5 = 40;
//        Integer i6 = new Integer(40);
//        //false
//        System.err.println(i5 == i6);
    }
}
