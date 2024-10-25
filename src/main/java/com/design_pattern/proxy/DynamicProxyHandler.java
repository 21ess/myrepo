package com.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class DynamicProxyHandler implements InvocationHandler{
    private Object proxyObject;

    public DynamicProxyHandler(Object proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 记录日志
        System.out.println("begin::" + method.getName());

        Object resultObject = method.invoke(proxyObject, args);

        System.out.println("end::" + method.getName());
        
        return resultObject;
    }
    
}
