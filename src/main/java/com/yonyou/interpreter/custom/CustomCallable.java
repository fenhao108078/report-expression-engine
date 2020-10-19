package com.yonyou.interpreter.custom;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

/**
 * none
 *
 * @author hlz
 * @date 2020年 10月15日 17:52:42
 */
public class CustomCallable implements Callable<Object> {
    private String sourceCode;

    public CustomCallable(String sourceCode) {
        this.sourceCode = sourceCode;
    }



    //方案2
    @Override
    public Object call() throws Exception {
        CustomRunContext runInfo = new CustomRunContext();
        Thread t1 = new Thread(() -> realCall(runInfo));
        t1.start();
        try {
            t1.join(3000); //等待3秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //不管有没有正常执行完成，强制停止t1
        t1.stop();
        return runInfo;
    }

    private void realCall(CustomRunContext runInfo) {
//        CompileContext compiler = new CompileContext(sourceCode);
//        if (compiler.compile()) {
//            runInfo.setCompilerSuccess(true);
//            try {
//                compiler.runMainMethod();
//                runInfo.setRunSuccess(true);
//                runInfo.setRunTakeTime(compiler.getRunTakeTime());
//                runInfo.setRunMessage(compiler.getRunResult()); //获取运行的时候输出内容
//            } catch (InvocationTargetException e) {
//                //反射调用异常了,是因为超时的线程被强制stop了
//                if ("java.lang.ThreadDeath".equalsIgnoreCase(e.getCause().toString())) {
//                    return;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                runInfo.setRunSuccess(false);
//                runInfo.setRunMessage(e.getMessage());
//            }
//        } else {
//            //编译失败
//            runInfo.setCompilerSuccess(false);
//        }
//        runInfo.setCompilerTakeTime(compiler.getCompilerTakeTime());
//        runInfo.setCompilerMessage(compiler.getCompilerMessage());
//        runInfo.setTimeOut(false); //走到这一步代表没有超时
    }
}
