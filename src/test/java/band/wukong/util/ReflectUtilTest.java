package band.wukong.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class ReflectUtilTest {

    @Test
    public void getFieldValue() throws NoSuchFieldException {
        final String NAME = "John Lennon";
        TestUserBean u = new TestUserBean(NAME);
        Field f = u.getClass().getDeclaredField("name");

        String val = (String) ReflectUtil.getFieldValue(u, f);

        Assert.assertTrue(NAME.equals(val));
    }

}
