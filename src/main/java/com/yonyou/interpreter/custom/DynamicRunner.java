package com.yonyou.interpreter.custom;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 动态代理生成类
 * 生成可监控的线程执行自定义方法
 *
 * @author hlz
 * @date 2020年 10月15日 14:37:46
 */
public class DynamicRunner {

    private final static ExecutorService EXECUTOR_POOL = Executors.newFixedThreadPool(1);


    //test
    private static class Run implements Runnable{

        int k;
        Run(int k){
            this.k = k;
        }
        @Override
        public void run() {
            try {
                helper(k);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    //test
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        Thread.sleep(2000);
        System.out.println("我开始了");
        for(int i=0;i<1;i++){
            Thread t = new Thread(new Run(i));
            t.start();
            System.out.println("线程开启");
            try {
                t.join(2000); //等待3秒
                t.stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.sleep(10);
        }

//        t.interrupt();


        System.out.println("======== 结束");
    }
    //test
    public static void helper(int args) throws ClassNotFoundException {
        String clazzName = "Test"+args;
        String javaCode = "package com.yonyou.dyc; " +
                "import java.util.*;" +
                "import com.yonyou.interpreter.custom.CompileContext;" +
                "public class " + clazzName + "{" +
                "public String testMethod(CompileContext c){" +

                //custom ========

                "for(int i=0;i<1;i++){" +
                "System.out.println(c.PACKAGE_REGEX);" +
                "}" +
                "return \"" + clazzName + " test end\";" +
                //custom end =====
                "}}";

        CompileContext c = new CompileContext(javaCode);
        byte[] bytes = DynamicLoader.compile(c);
        Class<?>[] clz = {CompileContext.class};
        Object[] arg = {new CompileContext(javaCode)};
        testRunner(c.getPackageName(), clazzName, bytes, arg, clz, "testMethod");
    }

    //test
    private static void testRunner(String packageName,String clazzName, byte[] bytes, Object[] args, Class<?>[] clz, String method) throws ClassNotFoundException {
        PrintStream out = System.out;
        try {
            long startTime = System.currentTimeMillis();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
//            System.setOut(printStream);
            DynamicLoader.MemoryClassLoader cl = new DynamicLoader.MemoryClassLoader(clazzName, bytes);
            Class<?> clazz = cl.findClass(packageName);

            Method main = clazz.getMethod(method, clz);

            Object o = clazz.getConstructor().newInstance();
            Object invoke = main.invoke(o, args);

            System.out.println("执行耗时 ====" + (System.currentTimeMillis() - startTime));
            System.out.println("执行结果 ====" + invoke.toString());
//            System.out.println(new String(outputStream.toByteArray(), StandardCharsets.UTF_8));

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        } finally {
//            还原默认打印的对象
            System.setOut(out);
        }
    }

}
