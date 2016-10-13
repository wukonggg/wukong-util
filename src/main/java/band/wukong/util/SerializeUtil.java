package band.wukong.util;

import java.io.*;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class SerializeUtil {

    /**
     * serial
     *
     * @param object object
     * @return bytes[]
     */
    public static byte[] serial(Object object) {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);

            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
        }
    }

    /**
     * deserialize
     *
     * @param bytes bytes
     * @return object
     */
    public static Object deserial(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;

        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);

            return ois.readObject();

        } catch (Exception e) {
            throw new RuntimeException(e);

        } finally {
            try {
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
        }
    }
}
