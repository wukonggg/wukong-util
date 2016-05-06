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
        InputStream is = null;
        try {
            is = Thread.currentThread().getClass().getResourceAsStream(file);
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("load properties file failed", e);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException ignored) {
                    ignored.printStackTrace();
                }
            }
        }
        return props;
    }

    public static Properties loadByFileInputStream(String file) {
        Properties props = new Properties();
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(file);
            props.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("load properties file failed", e);
        } finally {
            if (null != fs) {
                try {
                    fs.close();
                } catch (IOException ignored) {
                    ignored.printStackTrace();
                }
            }
        }
        return props;
    }

}