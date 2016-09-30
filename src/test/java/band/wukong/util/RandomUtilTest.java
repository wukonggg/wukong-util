package band.wukong.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class RandomUtilTest {

    @Test
    public void randomCapital() {
        for (int i = 0; i < 1000; i++) {
            String s = RandomUtil.randomCapital();
            boolean isCapital = RegexUtil.P_CAPITAL.matcher(s).matches();
            Assert.assertTrue(isCapital);
        }
    }

    @Test
    public void randomCapital2() {
        final String[] except = new String[] {"X", "J", "P"};
        final List<String> exceptList = Arrays.asList(except);
        for (int i = 0; i < 1000; i++) {
            String s = RandomUtil.randomCapital(except);
            boolean isCapital = RegexUtil.P_CAPITAL.matcher(s).matches();
            boolean hasExcepted = !exceptList.contains(s);
            Assert.assertTrue(isCapital && hasExcepted);
        }
    }

    @Test
    public void randomNumber() {
        final long start = 1;
        final long end = 100;
        for (int i = 0; i < 1000; i++) {
            long num = RandomUtil.randomNumber(start, end);
            Assert.assertTrue(num > start && num < end);
        }
    }

    @Test
    public void randomDate() {
        final String start = "2016-09-01";
        final String end = "2016-09-30";
        final long stime = DateUtil.parse(start).getTime();
        final long etime = DateUtil.parse(end).getTime();

        for (int i = 0; i < 1000; i++) {
            Date date = RandomUtil.randomDate(start, end);
            Assert.assertTrue(date.getTime() > stime && date.getTime() < etime);
        }
    }
}
