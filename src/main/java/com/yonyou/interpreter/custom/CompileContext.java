package com.yonyou.interpreter.custom;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 编译上下文
 *
 * @author hlz
 * @date 2020年 10月14日 18:11:34
 */
public class CompileContext {

    public final static String PACKAGE_REGEX = "package\\s+([^;]+);";

    private final static String CLASS_NAME_REGEX = "public\\s+class\\s+(\\w+)";

    //类名
    private final String className;

    //类全名
    private final String packageName;

    //编译源码
    private final String sourceCode;

    //存放编译过程中输出的信息
    private DiagnosticCollector<JavaFileObject> dc;

    //编译耗时(单位ms)
    private long compilerTakeTime;

    private byte[] clazzBytes;


    CompileContext(String className, String packageName, String sourceCode) {
        this.className = className;
        this.packageName = packageName;
        this.sourceCode = sourceCode;
    }


    CompileContext(String sourceCode) {

        this.sourceCode = sourceCode;

        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);

        Matcher matcher = pattern.matcher(sourceCode);

        if (matcher.find())
            this.className = matcher.group(1);
        else
            throw new RuntimeException("compile context init error : cannot find class name in Java code");

        pattern = Pattern.compile(PACKAGE_REGEX);

        matcher = pattern.matcher(sourceCode);

        if (matcher.find())
            this.packageName = matcher.group(1) + "." + className;
        else
            this.packageName = className;


    }

    public String getClassName() {
        return className;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public DiagnosticCollector<JavaFileObject> getDc() {
        return dc;
    }

    public void setDc(DiagnosticCollector<JavaFileObject> dc) {
        this.dc = dc;
    }

    public long getCompilerTakeTime() {
        return compilerTakeTime;
    }

    public void setCompilerTakeTime(long compilerTakeTime) {
        this.compilerTakeTime = compilerTakeTime;
    }

    public byte[] getClazzBytes() {
        return clazzBytes;
    }

    public void setClazzBytes(byte[] clazzBytes) {
        this.clazzBytes = clazzBytes;
    }

}
