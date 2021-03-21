package 创建型;

import lombok.Synchronized;

public class SingletonMode {
    //五种
    public static void main(String[] args) {

    }
    //第一种 饿汉
//    private static SingletonMode instance = new SingletonMode();
//    private SingletonMode() { }
//    public static SingletonMode getInstance() {
//        return instance;
//    }
    //第二种 懒汉 非线程安全，多个线程同时调用可能会引起重复创建
//    private static SingletonMode instance = null;
//    private SingletonMode() { }
//    public static SingletonMode getInstance() {
//        if (instance == null) {
//            instance = new SingletonMode();
//        }
//        return instance;
//    }
//      懒汉的线程安全版本
//    private static SingletonMode instance = null;
//    private SingletonMode() { }
//    public synchronized static SingletonMode getInstance() {
//        if (instance == null) {
//            instance = new SingletonMode();
//        }
//        return instance;
//    }
    //双重校验锁
//    大多数情况下走一遍if，但当多个线程时，会进行同步。
//    singleton = new Singleton(); 这段代码其实是分为三步执行：
//    为 singleton 分配内存空间
//    初始化 singleton
//    将 singleton 指向分配的内存地址
//    但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1–> 3 --> 2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。
//    例如，线程 T1 执行了 1 和 3，此时 T2 调用 getInstance() 后发现 singleton 不为空，因此返回 singleton ，但此时 singleton 还未被初始化。
//    使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
//        private static volatile SingletonMode instance = null;
//        private SingletonMode() {
//        }
//        public static SingletonMode getInstance() {
//            if (instance == null) {
//                synchronized (SingletonMode.class) {
//                    if (instance == null) {
//                        instance = new SingletonMode();
//                    }
//                }
//            }
//            return instance;
//        }
//  静态内部类 比上个方法实现简单
//        private SingletonMode() {}
//        private static class SingletonHolder {
//            private static SingletonMode INSTANCE = new SingletonMode();
//        }
//        public static SingletonMode getInstance() {
//            return SingletonHolder.INSTANCE;
//        }
//
    //以上四种均存在反序列化漏洞。
    //原理：jdk的源码InputStream在读对象的时候，会通过反射生成一个新的对象，而不是拿原来对象的引用。
    //如此一来单例模式就失效了。
    //防御方案
    //通过jdk的方法定义，告诉jdk该类反序列化的时候不要反射，而要使用自己定义的应用。
    //private Object readResolve(){
    //    return hungrySingleton;
    //}
    //
//  枚举不会有反序列化问题，因为java序列化对枚举做了特殊的规定。对于反射也是。
//    public enum SingletonMode {
//        INSTANCE;
//    }




}
