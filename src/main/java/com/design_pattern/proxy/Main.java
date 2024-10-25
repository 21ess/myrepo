package com.design_pattern.proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        RealFileUploader realFileUploader = new RealFileUploader();

        FileUploader fileUploaderProxy = new FileUploaderProxy(realFileUploader);

        fileUploaderProxy.upload();

        DynamicProxyHandler handler = new DynamicProxyHandler(realFileUploader);

        FileUploader proxyFileUploader = (FileUploader) Proxy.newProxyInstance(
                FileUploader.class.getClassLoader(),
                new Class[] { FileUploader.class },
                handler);
        
        proxyFileUploader.upload();
    }
}
