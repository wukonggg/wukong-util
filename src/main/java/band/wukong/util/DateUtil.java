package band.wukong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class DateUtil {
    public static final String FMT_YYYYMMDDHHMMSS_NO_SEP = "yyyyMMddHHmmSS";
    public static final String FMT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String FMT_YYYYMMDD = "yyyy-MM-dd";
    public static final String FMT_YYYYMMDD_NO_SEP = "yyyyMMdd";

    /**
     * 按传入的日期和格式转换至字符串格式
     *
     * @param date date
     * @param type DateUtils.
     * @return
     */
    public static String format(Date date, String type) {
        if (null == date) return "";
        String strDate = "";
        SimpleDateFormat fmt = null;
        try {
            fmt = new SimpleDateFormat(type);
        } catch (Exception e) {
            e.printStackTrace();
            return strDate;
        }
        strDate = fmt.format(date);
        return strDate;
    }

    /**
     * 生成短格式日期
     *
     * @param date date
     * @return YYYY-MM-DD
     */
    public static String format(Date date) {
        if (null == date) return "";
        return format(date, FMT_YYYYMMDD);
    }

    /**
     * String转化Date。
     *
     * @param date 支持的格式包括yyyyMMdd, yyyy-MM-dd, yyyy-MM-dd HH:mm:ss
     *
     * @return java.util.Date
     */
    public static Date parse(String date) {
        String re_yymmdd = "^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))$";
        if (date.matches(re_yymmdd)) {
            try {
                return new SimpleDateFormat(FMT_YYYYMMDD).parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        String re_yymmdd_hhmmss = "^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))\\p{Space}[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$";
        if (date.matches(re_yymmdd_hhmmss)) {
            try {
                return new SimpleDateFormat(FMT_YYYYMMDDHHMMSS).parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        String re_yymmdd_no_sep = "^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))$";
        if (date.matches(re_yymmdd_no_sep)) {
            try {
                return new SimpleDateFormat(FMT_YYYYMMDD_NO_SEP).parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        throw new IllegalArgumentException("传入参数格式不支持。");
    }

    /**
     * 查看两个日期是否是同一天
     *
     * @param d1 d1
     * @param d2 d2
     * @return true or false
     */
    public static boolean isSameDay(Date d1, Date d2) {
        return format(d1).equals(format(d2));
    }

}

/*
public static java.sql.Date convert2SqlDate(String date) {
    if (null == date) return null;
    if (date.equalsIgnoreCase("")) return null;
    try {
        return java.sql.Date.valueOf(date);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

*/
