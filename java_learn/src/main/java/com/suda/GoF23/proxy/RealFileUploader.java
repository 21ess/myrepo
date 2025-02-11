package com.suda.GoF23.proxy;

public class RealFileUploader implements FileUploader {

    @Override
    public void upload() {
        System.out.println("上传数据");
    }
}
