package com.geekbrains;

import com.geekbrains.Test.UnitTest;
import com.geekbrains.TestClasses.Test1;
import com.geekbrains.TestClasses.Test2;
import com.geekbrains.TestClasses.Test3;
import com.geekbrains.TestClasses.Test4;

public class RunTests {
    public static void main(String[] args) {
        UnitTest ut = new UnitTest();

        ut.test(Test1.class);
        System.out.println("======================================================================");
        try {
            ut.test(Test2.class);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("======================================================================");
        try {
            ut.test(Test3.class);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("======================================================================");
        try {
            ut.test(Test4.class);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
