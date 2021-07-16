package com.luban.util;

import com.luban.dao.CoustomInvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCustomHandler implements CoustomInvocationHandler {
    Object target;
    public TestCustomHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Method method) {
        try {
            System.out.println("----------------");
            return  method.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
