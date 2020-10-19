package com.yonyou.interpreter.custom;



import com.yonyou.interpreter.common.expression.NonTerminalExpression;
import com.yonyou.interpreter.common.expression.TerminalExpression;

import javax.tools.*;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DynamicLoader {

    private static volatile boolean DEBUG = true;

    public static void setDebug(boolean debug) {
        DEBUG = debug;
    }

    public static NonTerminalExpression getNonTerminalExp(){
        return null;
    }
    public static TerminalExpression getTerminalExp(){
        return null;
    }

    public static byte[] compile(String source) {
        return compile(new CompileContext(source));
    }

    public static byte[] compile(CompileContext context) {

        long startTime = System.currentTimeMillis();

        String javaName = context.getClassName() + ".java";

        String javaSrc = context.getSourceCode();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        if (context.getDc() == null) {
            context.setDc(new DiagnosticCollector<>());
        }

        DiagnosticCollector<JavaFileObject> dc = context.getDc();
        //标准文件管理器
        StandardJavaFileManager stdManager = compiler.getStandardFileManager(dc, null, StandardCharsets.UTF_8);

        try (MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager)) {
            JavaFileObject javaFileObject = MemoryJavaFileManager.makeStringSource(javaName, javaSrc);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, dc, null, null, Collections.singletonList(javaFileObject));

            if (task.call())
                context.setClazzBytes(manager.getClassBytes().get(context.getPackageName()));
            else {
                List<Diagnostic<? extends JavaFileObject>> diagnostics = dc.getDiagnostics();
                //TODO dc 编译错误信息
                System.out.println("+++++ 编译失败 ++++++");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        context.setCompilerTakeTime(System.currentTimeMillis() - startTime);

        //TODO 打印些编译上下文信息
        if (DEBUG)
            System.out.println("++++++ 编译完成 ++++++");

        return context.getClazzBytes();
    }

    public static class MemoryClassLoader extends URLClassLoader {

        Map<String, byte[]> classBytes = new HashMap<>();

        public MemoryClassLoader(Map<String, byte[]> classBytes) {
            super(new URL[0], MemoryClassLoader.class.getClassLoader());
            this.classBytes.putAll(classBytes);
        }

        public MemoryClassLoader(String clazzName, byte[] classBytes) {
            super(new URL[0], MemoryClassLoader.class.getClassLoader());
            this.classBytes.put(clazzName, classBytes);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (name == null || name.length() == 0)
                throw new NullPointerException("class name cannot be null");
            String[] c = name.split("\\.");
            byte[] buf = classBytes.get(c[c.length-1]);
            if (buf == null) {
                //只能使用自定义加载器
                throw new ClassNotFoundException(String.format("class : [%s] could not load", name));
            }
            classBytes.remove(name);
            return defineClass(name, buf, 0, buf.length);
        }
    }

}
