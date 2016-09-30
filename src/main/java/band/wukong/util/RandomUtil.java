package band.wukong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class RandomUtil {

    /**
     * 生成随机大写字母
     *
     * @return
     */
    public static String randomCapital() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return String.valueOf(chars.charAt((int) (Math.random() * 26)));
    }

    /**
     * 生成随机大写字母。范围A-Z。可以指定不包含的字符
     *
     * @param exceptCapitals 不包含的单个字母数组
     * @return
     */
    public static String randomCapital(String[] exceptCapitals) {
        if (null == exceptCapitals || exceptCapitals.length <= 0) {
            return "";
        }
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (String s : exceptCapitals) {
            chars = chars.replace(s, "");
        }
        return String.valueOf(chars.charAt((int) (Math.random() * (26 - exceptCapitals.length))));
    }

    /**
     * 生成随机数字，不包括上下限。
     *
     * @param begin 数字下限
     * @param end   数字上限
     * @return long型
     */
    public static long randomNumber(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return randomNumber(begin, end);
        }
        return rtn;
    }

    /**
     * 获取随机日期
     *
     * @param beginDate "yyyy-MM-dd"
     * @param endDate   "yyyy-MM-dd"
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date start = null;
        try {
            start = format.parse(beginDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date end = null;
        try {
            end = format.parse(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (start.getTime() >= end.getTime()) {
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            throw new IllegalArgumentException("传入参数不正确，beginDate大于endDate。");
        }
        long date = randomNumber(start.getTime(), end.getTime());

        return new Date(date);
    }

}
