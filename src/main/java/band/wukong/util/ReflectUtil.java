package band.wukong.util;

import java.lang.reflect.Field;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class ReflectUtil {

    /**
     * 获取对象中某个Field的值
     *
     * @param o
     * @param f
     * @return
     */
    public static Object getFieldValue(Object o, Field f) {
        Object val = null;
        try {
            if (f.isAccessible()) {
                val = f.get(o);
            } else {
                f.setAccessible(true);
                val = f.get(o);
                f.setAccessible(false);
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not get the value of field.", e);
        }
        return val;
    }

}
