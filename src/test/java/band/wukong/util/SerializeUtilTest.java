package band.wukong.util;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class SerializeUtilTest {

    @Test
    public void serial_and_deserial() throws IOException {
        String name = new File("./README.MD").getName();
        System.out.println(name);
        byte[] bytes = SerializeUtil.serial(name);
        System.out.println((String) SerializeUtil.deserial(bytes));
    }
}
