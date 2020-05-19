package com.example.demo.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 */
public class DateUtil {

    public static final long ONE_HOUR_TIME_LONG = 3600000;

    /**
     * 年(yyyy)
     */
    public static final String YEAR = "yyyy";

    /**
     * 年-月(yyyy-MM)
     */
    public static final String YEAR_MONTH = "yyyy-MM";

    /**
     * 年-月-日(yyyy-MM-dd)
     */
    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";

    /**
     * 年月日(yyyyMMdd)
     */
    public static final String YEAR_MONTH_DAY_SIMPLE = "yyyyMMdd";

    /**
     * 年-月-日 小时(yyyy-MM-dd HH)
     */
    public static final String YEAR_MONTH_DAY_HOUR = "yyyy-MM-dd HH";

    /**
     * 年-月-日 小时(yyyy-MM-dd HH)中文输出
     */
    public static final String YEAR_MONTH_DAY_HOUR_CN = "yyyy年MM月dd日HH时";

    /**
     * 年-月-日 小时:分钟(yyyy-MM-dd HH:mm)
     */
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy-MM-dd HH:mm";

    /**
     * 年-月-日 小时:分钟:秒钟(yyyy-MM-dd HH:mm:ss)
     */
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日小时分钟秒钟(yyyyMMddHHmmss)
     */
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SIMPLE = "yyyyMMddHHmmss";

    /**
     * 小时:分钟:秒钟(HH:mm:ss)
     */
    public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";

    /**
     * 小时:分钟(HH:mm)
     */
    public static final String HOUR_MINUTE = "HH:mm";

    /**
     * 月.日(M.d)
     */
    public static final String MONTH_DAY = "M.d";
    public static final String REG_EXP_DATE = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
    /**
     * 一天的秒数
     */
    private static final int DAY_SECOND = 24 * 60 * 60;
    /**
     * 一小时的秒数
     */
    private static final int HOUR_SECOND = 60 * 60;
    /**
     * 一分钟的秒数
     */
    private static final int MINUTE_SECOND = 60;

    public DateUtil() {
        System.setProperty("user.timezone", "Asia/Shanghai");
    }

    /**
     * 获取当前时间
     *
     * @return 返回当前时间
     */
    public static Date getCurrent() {
        return new Date();
    }

    /**
     * 获取当前时间并格式化
     *
     * @return 返回当前时间
     */
    public static String getCurrentDate(String format) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }

    /**
     * 获取下个月时间并格式化
     *
     * @return 返回当前时间
     */
    public static String getNextDate(String format) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        SimpleDateFormat dft = new SimpleDateFormat(format);
        String preMonth = dft.format(cal.getTime());
        return preMonth;
    }

    /**
     * 格式化日期时间
     *
     * @param date    Date对象
     * @param pattern 模式
     * @return 格式化后的日期时间字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null)
            return "";
        return new DateTime(date).toString(pattern);
    }

    /**
     * 格式化日期时间字符串
     *
     * @param dateString 日期时间字符串
     * @param pattern    模式
     * @return Date对象
     */
    public static Date formatDateString(String dateString, String pattern) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
            return dateTimeFormatter.parseDateTime(dateString).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据秒数获得x天x小时x分钟x秒字符串
     *
     * @param second 秒数
     * @return x天x小时x分钟x秒字符串
     */
    public static String getDayHourMinuteSecond(int second) {
        if (second == 0) {
            return "0秒";
        }
        StringBuilder sb = new StringBuilder();
        int days = second / DAY_SECOND;
        if (days > 0) {
            sb.append(days);
            sb.append("天");
            second -= days * DAY_SECOND;
        }

        int hours = second / HOUR_SECOND;
        if (hours > 0) {
            sb.append(hours);
            sb.append("小时");
            second -= hours * HOUR_SECOND;
        }

        int minutes = second / MINUTE_SECOND;
        if (minutes > 0) {
            sb.append(minutes);
            sb.append("分钟");
            second -= minutes * MINUTE_SECOND;
        }
        if (second > 0) {
            sb.append(second);
            sb.append("秒");
        }
        return sb.toString();
    }

    /**
     * 根据秒数获得x天x小时x分钟字符串
     *
     * @param second 秒数
     * @return x天x小时x分钟字符串
     */
    public static String getDayHourMinute(int second) {
        if (second == 0) {
            return "0分钟";
        }
        StringBuilder sb = new StringBuilder();
        int days = second / DAY_SECOND;
        if (days > 0) {
            sb.append(days);
            sb.append("天");
            second -= days * DAY_SECOND;
        }

        int hours = second / HOUR_SECOND;
        if (hours > 0) {
            sb.append(hours);
            sb.append("小时");
            second -= hours * HOUR_SECOND;
        }
        int minutes = second / MINUTE_SECOND;
        if (minutes > 0) {
            sb.append(minutes);
            sb.append("分钟");
        }
        return sb.toString();
    }

    /**
     * 获取只含有年月日的DateTime对象
     *
     * @param dateTime DateTime对象
     * @return 只含有年月日的DateTime对象
     */
    public static DateTime getDateOnly(DateTime dateTime) {
        return new DateTime(dateTime.toString(YEAR_MONTH_DAY));
    }

    /**
     * 获取当前周的周一和下周一
     *
     * @return 日期数组（索引0为周一，索引1为下周一）
     */
    public static Date[] getMondayAndNextMonday() {
        DateTime dateTime = getDateOnly(new DateTime());
        DateTime monday = dateTime.dayOfWeek().withMinimumValue();
        DateTime nextMonday = monday.plusDays(7);
        return new Date[]{monday.toDate(), nextMonday.toDate()};
    }

    /**
     * 获取指定时间的周一和周日
     *
     * @param dateTime DateTime对象
     * @return 日期数组（索引0为周一，索引1为周日）
     */
    public static Date[] getMondayAndSunday(DateTime dateTime) {
        dateTime = getDateOnly(dateTime);
        DateTime monday = dateTime.dayOfWeek().withMinimumValue();
        DateTime sunday = monday.plusDays(6);
        return new Date[]{monday.toDate(), sunday.toDate()};
    }

    /**
     * 和当前时间相比的天数差（正数为大于天数，负数为小于天数，零为同一天）
     *
     * @param date Date对象
     * @return 和当前时间相比的天数差
     */
    public static int compareDaysWithNow(Date date) {
        return Days.daysBetween(new DateTime(), new DateTime(date)).getDays();
    }

    /**
     * 和今天相比的天数差（正数为大于天数，负数为小于天数，零为同一天）
     *
     * @param date Date对象
     * @return 和今天相比的天数差
     */
    public static int compareDaysWithToday(Date date) {
        DateTime today = new DateTime();
        today = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 0, 0, 0, 0);
        DateTime compareDay = new DateTime(date);
        compareDay = new DateTime(compareDay.getYear(), compareDay.getMonthOfYear(), compareDay.getDayOfMonth(), 0, 0, 0, 0);
        return Days.daysBetween(today, compareDay).getDays();
    }

    /**
     * 比较时间a到时间b的天数差
     *
     * @param a 时间a
     * @param b 时间b
     * @return 相差天数
     */
    public static int compareDaysWithDay(Date a, Date b) {
        DateTime today = new DateTime(b);
        today = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 0, 0, 0, 0);
        DateTime compareDay = new DateTime(a);
        compareDay = new DateTime(compareDay.getYear(), compareDay.getMonthOfYear(), compareDay.getDayOfMonth(), 0, 0, 0, 0);
        return Days.daysBetween(today, compareDay).getDays();
    }

    /**
     * 比较两个时间是否相等（省略毫秒）
     *
     * @param date        Date对象
     * @param compareDate 比较Date对象
     * @return 是否相等
     */
    public static boolean compareDateIgnoreMillisecond(Date date, Date compareDate) {
        if (date == null && compareDate == null) {
            return true;
        } else if (date == null && compareDate != null) {
            return false;
        } else if (date != null && compareDate == null) {
            return false;
        }

        return (date.getTime() / 1000 == compareDate.getTime() / 1000);
    }

    /**
     * 根据秒数获取天数
     *
     * @param second 秒数
     * @return 天数
     */
    public static int getDay(int second) {
        return second / DAY_SECOND;
    }

    /**
     * 获取和今天相比的日期字符串
     *
     * @param date Date对象
     * @return 和今天相比的日期字符串
     */
    public static String getCompareWithTodayDateString(Date date) {
        int days = Math.abs(DateUtil.compareDaysWithToday(date));
        String dateString = "";
        if (days == 0) {
            dateString = "今天";
        } else if (days == 1) {
            dateString = "昨天";
        } else if (days == 2) {
            dateString = "2天前";
        } else if (days == 3) {
            dateString = "3天前";
        } else if (days == 4) {
            dateString = "4天前";
        } else if (days == 5) {
            dateString = "5天前";
        } else if (days == 6) {
            dateString = "6天前";
        } else if (days > 6 && days <= 14) {
            dateString = "1周前";
        } else if (days > 14 && days <= 21) {
            dateString = "2周前";
        } else if (days > 21 && days <= 30) {
            dateString = "3周前";
        } else if (days > 30) {
            dateString = "1月前";
        } else if (days > 365) {
            dateString = "1年前";
        } else if (days > 365 * 3) {
            dateString = "3年前";
        }
        return dateString;
    }

    /**
     * 比较两个时间相差分钟数
     *
     * @param now         当前时间
     * @param compareDate 比较时间
     * @return 相差分钟数
     */
    public static int compareMinutes(Date now, Date compareDate) {
        return (int) (now.getTime() - compareDate.getTime()) / 60000;
    }

    /**
     * 比较时间是本月的第几天
     *
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getDayOfMonth();
    }

    /**
     * 计算当月有几天
     *
     * @param date
     * @return
     */
    public static int getDateOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.dayOfMonth().getMaximumValue();
    }

    /**
     * 指定时间,判断该时间到现在时间的年数
     *
     * @param date 指定时间
     * @return 到现在时间的年数
     */
    public static int compareYear(Date date) {
        DateTime btd = new DateTime(date);
        DateTime nowDate = new DateTime();
        int year = 0;
        if (nowDate.getMonthOfYear() > btd.getMonthOfYear()) {
            year = nowDate.getYear() - btd.getYear();
        } else if (nowDate.getMonthOfYear() < btd.getMonthOfYear()) {
            year = nowDate.getYear() - btd.getYear() - 1;
        } else if (nowDate.getMonthOfYear() == btd.getMonthOfYear()) {
            if (nowDate.getDayOfMonth() >= btd.getDayOfMonth()) {
                year = nowDate.getYear() - btd.getYear();
            } else {
                year = nowDate.getYear() - btd.getYear() - 1;
            }
        }
        return year;
    }

    /**
     * 判断2个时间的时间差 返回字符串形式
     *
     * @param date  要对比的字符串
     * @param date2 要对比的字符串
     * @return 字符串形式 如1小时 ，2天2小时
     */
    public static String compareDaysWithDate(Date date, Date date2) {
        StringBuilder msg = new StringBuilder();
        int minutes = (int) Math.abs((date.getTime() - date2.getTime()) / 60000);
        if (minutes / 60 > 0 && minutes / 60 / 24 <= 0) {
            msg.append(minutes / 60 + "小时");
        }
        if (minutes / 60 / 24 > 0) {
            msg.append(minutes / 60 / 24 + "天");
            msg.append(minutes / 60 % 24 + "小时");
        }
        return msg.toString();
    }

    /**
     * 自动解析多种格式的时间字符串为时间对象<br>
     * 支持格式为：yyyy-MM-dd HH:mm:ss 支持多种分隔符，以及多种日期精度。 如yyyy年MM月。 HH时mm分ss秒
     *
     * @param dateString 时间字符串 <br>
     * @return 格式正确则返回对应的java.util.Date对象 格式错误返回null
     */
    public static Date formatUnknownString2Date(String dateString) {
        try {
            if (StringUtil.isEmpty(dateString)) {
                return null;
            }
            dateString = dateString.replace("T", " ");
            String hms = "00:00:00";
            dateString = dateString.trim();
            if (dateString.contains(" ")) {
                // 截取时分秒
                hms = dateString.substring(dateString.indexOf(" ") + 1);
                // 重置日期
                dateString = dateString.substring(0, dateString.indexOf(" "));
                // 多中分隔符的支持
                hms = hms.replace("：", ":");
                hms = hms.replace("时", ":");
                hms = hms.replace("分", ":");
                hms = hms.replace("秒", ":");
                hms = hms.replace("-", ":");
                hms = hms.replace("－", ":");
                // 时间不同精确度的支持
                if (hms.endsWith(":")) {
                    hms = hms.substring(0, hms.length() - 1);
                }
                if (hms.split(":").length == 1) {
                    hms += ":00:00";
                }
                if (hms.split(":").length == 2) {
                    hms += ":00";
                }
            }
            String[] hmsarr = hms.split(":");
            // 不同日期分隔符的支持
            dateString = dateString.replace(".", "-");
            dateString = dateString.replace("/", "-");
            dateString = dateString.replace("－", "-");
            dateString = dateString.replace("年", "-");
            dateString = dateString.replace("月", "-");
            dateString = dateString.replace("日", "");
            // 切割年月日
            String yearStr, monthStr, dateStr;
            // 截取日期
            String[] ymd = dateString.split("-");
            // 判断日期精确度
            yearStr = ymd[0];
            monthStr = ymd.length > 1 ? ymd[1] : "";
            dateStr = ymd.length > 2 ? ymd[2] : "";
            monthStr = monthStr == "" ? Integer.toString(1) : monthStr;
            dateStr = dateStr == "" ? Integer.toString(1) : dateStr;
            String dtr = (yearStr + "-" + monthStr + "-" + dateStr + " " + hms);
            if (!dtr.matches(REG_EXP_DATE))
                return null;
            // 返回日期
            return new DateTime(Integer.parseInt(yearStr.trim()), Integer.parseInt(monthStr.trim()), Integer.parseInt(dateStr.trim()), Integer.parseInt(hmsarr[0].trim()), Integer.parseInt(hmsarr[1].trim()), Integer.parseInt(hmsarr[2].trim()), 0).toDate();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 解析多个时间，指定时间之间的分隔符和时间的格式符 分隔符不能与格式符相同
     *
     * @param dateString 传入一个时间段字符串
     * @param spaceChar  指定格式符
     * @param splitChar  指定分隔符
     * @return 格式正确返回分割后的时间对象数组 格式错误返回null <br>
     * 指定了格式符为. 分隔符为- 返回值为 时间长度为2的Date类型数组<br>
     * 时间转换的方式详见 {@link DateTimeUtils#formatUnknownString2Date(String dateString)}
     */
    public static Date[] formatDatesByString(String dateString, String spaceChar, String splitChar) {
        if (spaceChar.equals(splitChar)) {
            return null;
        }
        String[] dateStrs = dateString.split(splitChar);
        Date[] dates = new Date[dateStrs.length];
        for (int i = 0, size = dateStrs.length; i < size; i++) {
            dates[i] = formatUnknownString2Date(dateStrs[i]);
        }
        return dates;
    }

    /**
     * 身份证号转生日
     *
     * @param identityCard 身份证
     * @return 生日
     */
    public static Date identityCard2Date(String identityCard) {
        try {
            String dateStr;
            if (identityCard.length() == 18) {
                dateStr = identityCard.substring(6, 14);// 截取18位身份证身份证中生日部分
                return formatDateString(dateStr, "yyyyMMdd");
            }
            if (identityCard.length() == 15) {
                dateStr = identityCard.substring(6, 12);// 截取15位身份证中生日部分
                return formatDateString(dateStr, "yyMMdd");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean validDate(String str) {
        try {
            Date date = formatUnknownString2Date(str);
            return date != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据周数，获取开始日期、结束日期
     *
     * @param week 周期  0本周，-1上周，-2上上周，1下周，2下下周
     * @return 返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date    日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date    日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date  日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date  日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date   日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date  日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }

    public static String toString(Date date, String format) {
        String dateStr = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            dateStr = sdf.format(date);
        } catch (Exception e) {
        }
        return dateStr;
    }

    public static Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 获取日期当天的最小时间日期,0点
     */
    public static Date getMinTimeDateByDate(Date date) {
        if (date == null)
            return null;
        String datestr = toString(date, "yyyyMMdd");
        return parseDate(datestr, "yyyyMMdd");
    }

    /**
     * 获取日期当天的最大时间日期,12点整
     */
    public static Date getMaxTimeDateByDate(Date date) {
        if (date == null)
            return null;
        String datestr = toString(date, "yyyyMMdd");
        Date d = parseDate(datestr, "yyyyMMdd");
        return new Date(d.getTime() + 24L * 60L * 60L * 1000L - 1L);
    }

    public static long subTime(Date startDate, Date endDate) {
        return endDate.getTime() - startDate.getTime();
    }

    /**
     * 获取上月第一天最早时间
     *
     * @return Date
     */
    public static Date getLastMonthFirstDay() {
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        cal_1.setTime(getMinTimeDateByDate(new Date()));
        cal_1.add(Calendar.MONTH, -1);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        return cal_1.getTime();
    }

    /**
     * 获取上月最后一天最晚时间
     *
     * @return Date
     */
    public static Date getLastMonthLastDay() {
        Calendar cale = Calendar.getInstance();
        cale.setTime(getMinTimeDateByDate(new Date()));
        cale.add(Calendar.MONTH, -1);
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new Date(cale.getTime().getTime() + 1000L * 60L * 60L * 24L - 1L);
    }

    /**
     * 获取本月第一天最早时间
     *
     * @return Date
     */
    public static Date getNowMonthFirstDay() {
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        cal_1.setTime(getMinTimeDateByDate(new Date()));
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        return cal_1.getTime();
    }

    /**
     * 获取本月最后一天最晚时间
     *
     * @return Date
     */
    public static Date getNowMonthLastDay() {
        Calendar cale = Calendar.getInstance();
        cale.setTime(getMinTimeDateByDate(new Date()));
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new Date(cale.getTime().getTime() + 1000L * 60L * 60L * 24L - 1L);
    }

    /**
     * 获取本月最后一天
     *
     * @return Date
     */
    public static Date getTheMonthLastDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
        cale.set(Calendar.HOUR, 0);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        cale.set(Calendar.MILLISECOND, 0);
        return cale.getTime();
    }

    /**
     * 获取格式化的时间，默认是yyyy-MM-dd HH:mm:ss此格式
     *
     * @return
     */
    public static String GetFormatTime() {
        DateTime dateTime = new DateTime().withZone(DateTimeZone.forID("Asia/Shanghai")).toLocalDateTime().toDateTime();
        try {
            return dateTime.toString("yyyy-MM-dd HH:mm:ss");
        } catch (Exception ex) {
            ex.printStackTrace();
            return dateTime.toString();
        }
    }

    /**
     * 获取格式化的时间
     *
     * @param formatter 时间格式化字符串
     * @return
     */
    public static String GetFormatTime(String formatter) {
        DateTime dateTime = new DateTime().withZone(DateTimeZone.forID("Asia/Shanghai")).toLocalDateTime().toDateTime();
        try {
            return dateTime.toString(formatter);
        } catch (Exception ex) {
            ex.printStackTrace();
            return dateTime.toString("yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 获取格式化的时间字符串
     *
     * @param formatTime 自定义时间
     * @param formatter  格式化规则
     * @return
     */
    public static String GetFormatTime(Date formatTime, String formatter) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        try {
            return sdf.format(formatTime);
        } catch (Exception ex) {
            return GetFormatTime(formatter);
        }
    }

    /**
     * 短时间变长时间
     *
     * @param tmp 格式：20190301
     * @return
     */
    public static String sortTimeToLongTime(String tmp) {
        return tmp.substring(0, 4) + "-" + tmp.substring(4, 6) + "-" + tmp.substring(6, 8);
    }

    /**
     * 判断时间是否符合对比度
     *
     * @param month      要比对的月份
     * @param limitMonth 要获取当前时间的前几个月或后几个月的偏移量
     * @param days       要对比的天数
     * @return 返回结果，0、不做任何操作，1、月份和天数都在可操作范围，2、月份在可操作范围
     */
    /*public static Integer compares(String month, Integer limitMonth, Integer days) {
        if (StringUtil.isEmpty(month)) {
            return 0;
        }
        RemindDateUtils remindDateUtils = new RemindDateUtils();
        String limitMonths = GetFormatTime(remindDateUtils.getBeforeMonth(limitMonth), "MM");
        String day = GetFormatTime("dd");
        if (Integer.parseInt(month) >= Integer.parseInt(limitMonths)) {
            if (Integer.parseInt(month) == Integer.parseInt(limitMonths)) {
                if (Integer.parseInt(day) <= days) {
                    return 1;
                }
            } else if (Integer.parseInt(month) > Integer.parseInt(limitMonths)) {
                return 2;
            }
        }
        return 0;
    }*/

}
