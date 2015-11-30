package band.wukong.util;

import java.io.*;
import java.util.Properties;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class PropertiesUtil {

    public static Properties loadByResourceAsStream(String file) {
        Properties props = new Properties();
        try {
            props.load(Thread.currentThread().getClass().getResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("load properties file failed", e);
        }
        return props;
    }

    public static Properties loadByFileInputStream(String file) {
        Properties props = new Properties();
        try {
            FileInputStream fs = new FileInputStream(file);
            props.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("load properties file failed", e);
        }
        return props;
    }

}