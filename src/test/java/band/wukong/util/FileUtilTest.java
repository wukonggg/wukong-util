package band.wukong.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * description
 *
 * @author wukong(wukonggg@139.com)
 */
public class FileUtilTest {

    private String file;

    @Before
    public void setUp() {
        file = "./src/test/resources/test.properties";
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getFileExtension() {
        File gimg = new File("C:/a.txt");
        String ext = FileUtil.getFileExtension(gimg);
        Assert.assertEquals("出错啦！", "txt", ext);
    }

    @Test
    public void getFileNameWithoutExtension() {
        File file = new File("C:/a.txt");
        String name = FileUtil.getFileNameWithoutExtension(file.getName());
        Assert.assertEquals("出错啦！", "a", name);
    }

    @Test
    public void readLines() {
        List<String> slist = FileUtil.readLines(file);
//        PrintUtil.println(System.out, slist);
        Assert.assertTrue(slist.size() == 1);

    }
}
