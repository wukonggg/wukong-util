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
public class PropertiesUtilTest {
    private String file;

    @Before
    public void setUp() {
        file = "/test.properties";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void read() {
        String driverName = PropertiesUtil.read(file, "hive.jdbc.drivername");
        String userName = PropertiesUtil.read(file, "hive.jdbc.username");
        Assert.assertEquals("org.apache.hadoop.hive.jdbc.HiveDriver", driverName);
        Assert.assertEquals("", userName);
    }
}
