package band.wukong.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class PropertiesUtilTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadByResourceAsStream() {
        Properties props = PropertiesUtil.loadByResourceAsStream("/test.properties");
        Assert.assertEquals("wukong-util", props.getProperty("project.artifactId"));
    }

    @Test(expected = NullPointerException.class)
    public void loadByResourceAsStream_failed1() {
        PropertiesUtil.loadByResourceAsStream("./test.properties");
    }

    @Test(expected = NullPointerException.class)
    public void loadByResourceAsStream_failed2() {
        PropertiesUtil.loadByResourceAsStream("test.properties");
    }

    @Test
    public void loadByFileInputStream() {
//        System.out.println("user.dir = " + System.getProperty("user.dir"));
//        Properties props = PropertiesUtil.loadByFileInputStream("D:\\Lab\\ws-wukong\\wukong-util\\src\\test\\resources\\test.properties");
//        Properties props = PropertiesUtil.loadByFileInputStream("./src/test/resources/test.properties");
        Properties props = PropertiesUtil.loadByFileInputStream("src/test/resources/test.properties");
        Assert.assertEquals("wukong-util", props.getProperty("project.artifactId"));

    }

}
