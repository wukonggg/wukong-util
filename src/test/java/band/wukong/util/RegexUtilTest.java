package band.wukong.util;

import org.junit.Assert;
import org.junit.Test;


/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class RegexUtilTest {

    @Test
    public void matches() {
        Assert.assertTrue(RegexUtil.P_DATE_YYYYMMDD.matcher("2015-07-08").matches());       //日期格式正确
        Assert.assertTrue(RegexUtil.P_DATE_YYYYMMDD.matcher("0014-01-03").matches());       //这个测试年份
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("2014-02-29").matches());      //日期范围不正确---平年2月没有29号
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("2014-13-03").matches());      //日期月份范围不正确---月份没有13月
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("2014-06-31").matches());      //日期范围不正确---6月没有31号
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("2014-01-32").matches());      //日期范围不正确 ----1月超过31天
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("2015-07-081").matches());
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("12015-07-081").matches());
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("2015-708").matches());
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("20150708").matches());
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("00014-01-03").matches());
        Assert.assertFalse(RegexUtil.P_DATE_YYYYMMDD.matcher("01014-01-011").matches());

        Assert.assertTrue(RegexUtil.P_DATE_YYYYMMDD_HHMMSS.matcher("2015-07-08 00:00:00").matches());
        Assert.assertTrue(RegexUtil.P_DATE_YYYYMMDD_HHMMSS.matcher("2015-07-08 23:59:59").matches());


        Assert.assertTrue(RegexUtil.P_EMAIL.matcher("wukonggg@139.com").matches());
        Assert.assertFalse(RegexUtil.P_EMAIL.matcher("wukonggg139.com").matches());
        Assert.assertFalse(RegexUtil.P_EMAIL.matcher("@139com").matches());
        Assert.assertFalse(RegexUtil.P_EMAIL.matcher("@139.com").matches());
        Assert.assertFalse(RegexUtil.P_EMAIL.matcher("wukonggg@139com").matches());

        Assert.assertTrue(RegexUtil.P_CHAR26_INT_GT0.matcher("abdziosdfhoi8865").matches());
        Assert.assertFalse(RegexUtil.P_CHAR26_INT_GT0.matcher("abdziosdfho_").matches());
        Assert.assertFalse(RegexUtil.P_CHAR26_INT_GT0.matcher("abdziosdf$ho").matches());

        Assert.assertTrue(RegexUtil.P_CHAR26_INT_UNDERLINE.matcher("abd_kalsj888").matches());
        Assert.assertFalse(RegexUtil.P_CHAR26_INT_UNDERLINE.matcher("wukonggg@139com").matches());


    }
}
