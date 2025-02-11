package com.suda.GoF23.proxy;

public class FileUploaderProxy implements FileUploader {
    private FileUploader realFileUploader;  // 静态代理实现

    public FileUploaderProxy(FileUploader realFileUploader) {
        this.realFileUploader = realFileUploader;
    }

    @Override
    public void upload() {
        // AOP编程
        System.out.println("begin::");
        
        realFileUploader.upload();

        System.out.println("::end");
    }
}
