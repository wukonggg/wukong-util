package band.wukong.util;

import java.util.regex.Pattern;

/**
 * Description: 正则表达式工具类
 * Author: wukong(wukonggg@139.com)
 * Date: 2009-10-31 8:58:10
 */
public class RegexUtil {

    /**
     * Pattern: ABCDEFGHIJKLMNOPQRSTUVWXYZ
     */
    public static final Pattern P_CAPITAL = Pattern.compile("[A-Z]");

    /**
     * Pattern: date string in format "YYYY-MM-DD"
     */
    public static final Pattern P_DATE_YYYYMMDD = Pattern.compile("^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))$");

    /**
     * Pattern: date string in format "YYYY-MM-DD hh:mm:ss"
     */
    public static final Pattern P_DATE_YYYYMMDD_HHMMSS = Pattern.compile("^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]|[0-9][1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))\\p{Space}[0-2][0-9]:[0-5][0-9]:[0-5][0-9]$");

    /**
     * Pattern: email
     */
    public static final Pattern P_EMAIL = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");

    /**
     * Pattern: 正整数&26个英文字母
     */
    public static Pattern P_CHAR26_INT_GT0 = Pattern.compile("^[A-Za-z0-9]+$");

    /**
     * Pattern: 数字、26个英文字母和下划线
     */
    public static Pattern P_CHAR26_INT_UNDERLINE = Pattern.compile("^\\w+$");

    /**
     * 密码：以字母开头，长度在6~18之间，只能包含字符、数字和下划线。
     */
    public static Pattern P_PASSWORD = Pattern.compile("^[a-zA-Z]\\w{5,17}$");

}
