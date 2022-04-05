package com.geekbrains.TestClasses;

import com.geekbrains.Test.Test;
import com.geekbrains.Test.BeforeSuite;
import com.geekbrains.Test.AfterSuite;
import com.geekbrains.Test.UnitTest;

public class Test4 {

    @BeforeSuite
    public void init() {
        System.out.println("Init - BeforeSuite");
    }

    @Test
    public void Test1() {
        System.out.println("Test 1");
    }

    @AfterSuite
    public void close() {
        System.out.println("Close - AfterSuite");
    }

    @AfterSuite
    public void close2() {
        System.out.println("Close - AfterSuite");
    }

}