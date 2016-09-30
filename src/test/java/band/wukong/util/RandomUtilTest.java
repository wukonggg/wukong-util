package band.wukong.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
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
        String[] except = new String[] {"X", "J", "P"};
        List<String> exceptList = Arrays.asList(except);
        for (int i = 0; i < 1000; i++) {
            String s = RandomUtil.randomCapital(except);
            boolean isCapital = RegexUtil.P_CAPITAL.matcher(s).matches();
            boolean hasExcepted = !exceptList.contains(s);
            Assert.assertTrue(isCapital && hasExcepted);
        }
    }


    @Test
    public void randomNumber() {
        long start = 1;
        long end = 100;
        for (int i = 0; i < 1000; i++) {
            long num = RandomUtil.randomNumber(start, end);
            Assert.assertTrue(num > start && num < end);
        }
    }

}
