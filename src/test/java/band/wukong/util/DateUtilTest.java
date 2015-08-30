package band.wukong.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

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
    public void convert2date() {
        Assert.assertNotNull(DateUtil.convert2date("2015-01-31"));
        Assert.assertNotNull(DateUtil.convert2date("2015-01-31 00:00:00"));
        Assert.assertNotNull(DateUtil.convert2date("2015-01-31 23:59:59"));

    }

    @Test
    public void convert2date_failed() {
        boolean catched = false;
        try {
            DateUtil.convert2date("2015-01-32");
        } catch (RuntimeException e) {
            catched = true;
        }
        if (!catched) {
            throw new RuntimeException("没有捕捉到异常");
        }

        try {
            catched = false;
            DateUtil.convert2date("2015-02-30");
        } catch (RuntimeException e) {
            catched = true;
        }
        if (!catched) {
            throw new RuntimeException("没有捕捉到异常");
        }

        try {
            catched = false;
            DateUtil.convert2date("2015-01-31 00:00:60");
        } catch (RuntimeException e) {
            catched = true;
        }
        if (!catched) {
            throw new RuntimeException("没有捕捉到异常");
        }
    }
}
