package band.wukong.util;

import java.lang.reflect.Field;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class ReflectUtil {

    /**
     * 获取对象中某个Field的值。如果object或者field为null，则返回null
     *
     * @param o object
     * @param f field
     * @return field value
     */
    public static Object getFieldValue(Object o, Field f) {
        if (null == o || null == f) {
            return null;
        }

        Object val = null;
        try {
            if (f.isAccessible()) {
                val = f.get(o);
            } else {
                f.setAccessible(true);
                val = f.get(o);
                f.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Could not get the value of field.", e);
        }
        return val;
    }

}
