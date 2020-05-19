package com.example.demo.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具类
 *
 * @author: lixuanli
 * @date: 2018/4/16 13:27
 */
public class StringUtil {

    /**
     * 获取两字符串的相似度
     *
     * @param str    需要比对字符串
     * @param target 比对目标字符串
     */
    public static float getSimilarityRatio(String str, String target) {
        return 1 - (float) compare(str, target) / Math.max(str.length(), target.length());

    }

    /**
     * 生成对应模块单据名称
     *
     * @param customerName 客户名称
     * @param moduleName   模块名称
     * @param dateFormat   日期格式
     * @return 单据名称
     * @author: lixuanli
     * @date: 2018/5/9 09:52
     */
    public static String getTitleByModule(String customerName, String moduleName, String dateFormat) {
        String currentDate = DateUtil.getCurrentDate(dateFormat);
        return customerName + "_" + moduleName + "_" + currentDate;
    }

    /**
     * 生成对应模块单号
     *
     * @param number                单号序列
     * @param numberFormat          单号格式
     * @param moduleShortName       模块简称
     * @param customerAreaShortName 客户地区简称
     * @param dateFormat            日期格式
     * @return
     * @author: lixuanli
     * @date: 2018/5/9 10:02
     */
    public static String getNumberByMOdule(int number, String numberFormat, String moduleShortName, String customerAreaShortName, String dateFormat) {
        NumberFormat nf = new DecimalFormat(numberFormat);
        String sNumber = nf.format(number);
        String currentYear = DateUtil.getCurrentDate(dateFormat);
        return moduleShortName + "-" + customerAreaShortName + "-" + currentYear + "-" + sNumber;
    }

    /**
     * 方法描述 ：  生成下个月对应模块单号
     *
     * @param number                单号序列
     * @param numberFormat          单号格式
     * @param moduleShortName       模块简称
     * @param customerAreaShortName 客户地区简称
     * @param dateFormat            日期格式
     * @return
     * @author fangxs
     * @date 2018年7月23日
     */
    public static String getNextMonNumberByMOdule(int number, String numberFormat, String moduleShortName, String customerAreaShortName, String dateFormat) {
        NumberFormat nf = new DecimalFormat(numberFormat);
        String sNumber = nf.format(number);
        String currentYear = DateUtil.getNextDate(dateFormat);
        return moduleShortName + "-" + customerAreaShortName + "-" + currentYear + "-" + sNumber;
    }

    private static int compare(String str, String target) {
        int[][] d; // 矩阵
        int n = str.length();
        int m = target.length();
        int i; // 遍历str的
        int j; // 遍历target的
        char ch1; // str的
        char ch2; // target的
        int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1

        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        d = new int[n + 1][m + 1];

        // 初始化第一列
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }
        // 初始化第一行
        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }
        // 遍历str
        for (i = 1; i <= n; i++) {
            ch1 = str.charAt(i - 1);
            // 去匹配target
            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }

                // 左边+1,上边+1, 左上角+temp取最小
                d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
            }
        }
        return d[n][m];
    }

    private static int min(int one, int two, int three) {
        return (one = one < two ? one : two) < three ? one : three;
    }

    /**
     * String 字符串转 List集合
     *
     * @param tmp
     * @param splitStr 切割字符串
     * @return
     */
    public static List<String> stringToList(String tmp, String splitStr) {
        List<String> listObj = new ArrayList<>();
        String[] ids = tmp.split(splitStr);
        for (Integer i = 0; i < ids.length; i++) {
            if (!isEmpty(ids[0])) {
                listObj.add(ids[i]);
            }
        }
        return listObj;
    }

    /**
     * 是否为空字符串(包含"null")
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    /**
     * 获取字符串值
     *
     * @param str
     * @return
     */
    public static String getValue(Object str) {
        return isEmpty(str) ? "" : String.valueOf(str);
    }

    /**
     * 判断两个字符结果是否相同
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equales(Object str1, Object str2) {
        return getValue(str1).equals(str2);
    }
}