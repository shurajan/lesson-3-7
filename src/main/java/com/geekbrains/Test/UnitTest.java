package com.geekbrains.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UnitTest {


    public static void test(Class testClass) {
        Object testClassObject = null;
        Constructor counstructor = null;
        int beforeSuiteCounter = 0;
        int afterSuiteCounter = 0;

        try {
            counstructor = testClass.getConstructor();
            testClassObject = counstructor.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Method[] methods = testClass.getDeclaredMethods();
        List<MethodContainer> testCases = new ArrayList<>(methods.length);
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeSuiteCounter++;
                testCases.add(new MethodContainer(method, Priorities.MAX_PRIORITY - 1));
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                afterSuiteCounter++;
                testCases.add(new MethodContainer(method, Priorities.MIN_PRIORITY + 1));
            } else if (method.getAnnotation(Test.class) != null) {
                int priority = method.getAnnotation(Test.class).priority();
                if (priority > Priorities.MIN_PRIORITY || priority < Priorities.MAX_PRIORITY)
                    throw new RuntimeException("Некорректный приоритет - " + priority + " у метода " + method.getName());
                testCases.add(new MethodContainer(method, priority));
            }
        }

        if (beforeSuiteCounter != 1)
            throw new RuntimeException("Должен быть 1 метод c аннотацией @BeforeSuite");

        if (afterSuiteCounter != 1)
            throw new RuntimeException("Должен быть 1 метод c аннотацией @AfterSuite");

        List<MethodContainer> sortedTestCases = testCases.stream()
                .sorted(Comparator.comparingInt(MethodContainer::getPriority))
                .collect(Collectors.toList());

        for (MethodContainer m : sortedTestCases) {
            try {
                System.out.println("Вызываем метод - " + m);
                m.getMethod().invoke(testClassObject,null);
                System.out.println("-----------------------------------------------------------------");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
