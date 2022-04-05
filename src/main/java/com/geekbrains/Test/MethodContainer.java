package com.geekbrains.Test;

import java.lang.reflect.Method;

public class MethodContainer {
    private Method method;
    private int priority;

    public MethodContainer(Method method, int priority) {
        this.method = method;
        this.priority = priority;
    }

    public Method getMethod() {
        return method;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString(){
        return "[Method " + this.method.getName() + ", priority "  + this.priority + "]";
    }
}