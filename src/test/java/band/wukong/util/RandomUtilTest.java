package band.wukong.util;

import org.junit.Test;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class RandomUtilTest {

    @Test
    public void randomCapital() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.randomCapital());
        }
    }

    @Test
    public void randomCapital2() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(RandomUtil.randomCapital(new String[] {"O"}));
        }
    }

}
