package band.wukong.util;

import java.io.*;
import java.util.Properties;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class PropertiesUtil {

    public static String read(String file, String propName) {
        Properties p = load(file);
        return p.getProperty(propName);

    }

    public static Properties load(String file) {
        Properties p = new Properties();
        InputStream is = PropertiesUtil.class.getResourceAsStream(file);
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("load properties file failed", e);
        }
        return p;
    }

}