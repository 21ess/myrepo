package com.design_pattern.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/***
 * 使用CGLib来实现代理
 * CGLib速度更快，性能更好，并且是基于继承实现的，不需要代理对象实现某个接口
 */
public class FileUploaderGenerator implements MethodInterceptor{

    

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        
    }
    
}
