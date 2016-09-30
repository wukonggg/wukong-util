package band.wukong.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class DateUtilTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void parse_success() {
        Assert.assertNotNull(DateUtil.parse("20150131"));
        Assert.assertNotNull(DateUtil.parse("20160901"));
        Assert.assertNotNull(DateUtil.parse("2015-01-31"));
        Assert.assertNotNull(DateUtil.parse("2015-01-31 00:00:00"));
        Assert.assertNotNull(DateUtil.parse("2015-01-31 23:59:59"));

    }

    @Test
    public void parse_failed() {
        boolean failed = false;

        try {
            DateUtil.parse("20151301");
        } catch (RuntimeException e) {
            failed = true;
        }

        try {
            DateUtil.parse("2015-01-32");
        } catch (RuntimeException e) {
            failed = true;
        }
        if (!failed) {
            throw new RuntimeException("没有捕捉到异常");
        }

        try {
            failed = false;
            DateUtil.parse("2015-02-30");
        } catch (RuntimeException e) {
            failed = true;
        }
        if (!failed) {
            throw new RuntimeException("没有捕捉到异常");
        }

        try {
            failed = false;
            DateUtil.parse("2015-01-31 00:00:60");
        } catch (RuntimeException e) {
            failed = true;
        }
        if (!failed) {
            throw new RuntimeException("没有捕捉到异常");
        }
    }
}
