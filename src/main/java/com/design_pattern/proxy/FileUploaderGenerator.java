package com.design_pattern.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/***
 * 使用CGLib来实现代理
 * CGLib速度更快，性能更好，并且是基于继承实现的，不需要代理对象实现某个接口
 */
public class FileUploaderGenerator implements MethodInterceptor{

    private Object tarObject;
    public FileUploaderGenerator(Object tarObject) {
        this.tarObject = tarObject;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        // 通过字节码创建子类来实现代理（代理设置拦截器，对于父类的调用使用子类的实现）
        enhancer.setSuperclass(tarObject.getClass());
        enhancer.setCallback(this);
        // 返回子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println("begin::");
        Object invokeSuper = arg3.invokeSuper(arg0, arg2);
        System.out.println("::end");
        return invokeSuper;
    }
    
}
