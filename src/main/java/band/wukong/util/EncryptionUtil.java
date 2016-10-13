package band.wukong.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class EncryptionUtil {
    /**
     * 算法枚举
     */
    public static enum Algorithm {
        MD5, SHA1
    }

    /**
     * 加密。支持MD5和SHA
     *
     * @param source    source string
     * @param algorithm 算法，见EncryptionUtil.Algorithm
     * @return string encrypted
     */
    public static String encrypt(String source, Algorithm algorithm) {
        if (algorithm == Algorithm.MD5) {
            try {
                return md5(source);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

        } else if (algorithm == Algorithm.SHA1) {
            try {
                return sha1(source);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        throw new UnsupportedOperationException();
    }

    private static String md5(String source) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] byteArray = source.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    private static String sha1(String source) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA1");
        byte[] byteArray = source.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuilder hexValue = new StringBuilder();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }
}
//参考资料：http://www.blogjava.net/amigoxie/archive/2014/06/01/414299.html
