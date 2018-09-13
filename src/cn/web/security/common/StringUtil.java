package cn.web.security.common;

public class StringUtil {

	/**
     * 判断是否是空字符串 null和"" 都返回 true
     *
     * @param str 判断的字符串
     * @return 是否有效
     */
    public static boolean isNULLOREmpty(String str) {
        return str == null || str.equals("") || str.trim().length() == 0;
    }
}
