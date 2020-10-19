package com.yonyou.interpreter.util;

/**
 * 字符串匹配工具类
 *
 * @author hlz
 * @date 2020年 10月14日 17:32:46
 */
public class StringMatchUtils {

    /**
     * 查找第一个匹配的符号，返回index
     *
     * @param cs     exp
     * @param symbol regx
     * @return index
     */
    public static int kmp(char[] cs, String symbol) {
        return kmp(cs, 0, -1, null, symbol);
    }

    /**
     * kmp搜索区间内的匹配字符串的下标值
     * 如果搜索到返回开始下标
     * 如果未搜索到返回-1；
     *
     * @param cs     被搜索串字符数组（复用）
     * @param st     开始下标
     * @param end    结束下标+1
     * @param pmt    部分匹配表
     * @param symbol 匹配字符串
     * @return 匹配下标
     */
    public static int kmp(char[] cs, int st, int end, int[] pmt, String symbol) {
        if (end == -1)
            end = cs.length;
        if (pmt == null)
            pmt = pmt(symbol);
        char[] ss = symbol.toCharArray();
        int i = st, j = 0, cl = end, sl = ss.length;
        while (i < cl && j < sl) {
            if (j == -1 || cs[i] == ss[j]) {
                i++;
                j++;
            } else j = pmt[j];

        }
        if (j == sl)
            return i - j;
        else
            return -1;
    }

    /**
     * 部分匹配表，不知道拿dp写有啥bug，
     * 但性能更好些
     *
     * @param regex 匹配传
     * @return pmt
     */
    public static int[] pmt(String regex) {
        char[] cs = regex.toCharArray();
        int[] dp = new int[cs.length];
        for (int i = 1; i < cs.length - 1; i++) {
            int pre = cs[i] == cs[0] ? 1 : 0;
            dp[i + 1] = cs[i] == cs[dp[i - 1]]
                    ? dp[i - 1] + 1 : pre;
        }
        dp[0] = -1;
        return dp;
    }

}
