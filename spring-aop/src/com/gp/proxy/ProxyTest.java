package com.gp.proxy;

/**
 * @author Gp
 * @create 2020/4/22 18:42
 */
public class ProxyTest {
    public static void main(String[] args) {
//        PublicInterface instance = new TargetInstanceImpl();
//        PublicInterface proxyInstance = new ProxyInstance(instance);
//        proxyInstance.buy();
//        动态代理
        PublicInterface targetInstance = new TargetInstanceImpl();
        ProxyInstance proxy = new ProxyInstance(targetInstance);
        //得到目标对象的代理对象
        PublicInterface proxy1 = (PublicInterface) proxy.getInstance();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        proxy1.buy();

//        Factory2 factory2 = new Factory2Impl();
//        ProxyInstance proxyInstance = new ProxyInstance(factory2);
//        Factory2 proxy2 = (Factory2) proxyInstance.getInstance();
//        proxy2.creat();

    }
}
