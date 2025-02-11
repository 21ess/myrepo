import com.suda.GoF23.proxy.*;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // 静态代理
       RealFileUploader realFileUploader = new RealFileUploader();

        FileUploader fileUploaderProxy = new FileUploaderProxy(realFileUploader);

        fileUploaderProxy.upload();

        // jdk 动态代理
        DynamicProxyHandler handler = new DynamicProxyHandler(realFileUploader);

        FileUploader proxyFileUploader = (FileUploader) Proxy.newProxyInstance(
                FileUploader.class.getClassLoader(),
                new Class[] { FileUploader.class },
                handler);
        
        proxyFileUploader.upload();

        // CGLib 动态代理
        FileUploaderGenerator proxyGenerator = new FileUploaderGenerator(realFileUploader);
        FileUploader proxy = (FileUploader) proxyGenerator.getProxy();
        proxy.upload();

    }
}
