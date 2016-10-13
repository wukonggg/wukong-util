package band.wukong.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public class EncryptionUtilTest {

    /* *********************************************************** */
    /* ***************** some RFC1321 test case ****************** */
    /* *********************************************************** */
    private static final String MD5_EMPTY = "";
    private static final String MD5_EMPTY_EN = "d41d8cd98f00b204e9800998ecf8427e";
    private static final String MD5_A_LOWERCASE = "a";
    private static final String MD5_A_LOWERCASE_EN = "0cc175b9c0f1b6a831c399e269772661";
    private static final String MD5_ABC_LOWERCASE = "abc";
    private static final String MD5_ABC_LOWERCASE_EN = "900150983cd24fb0d6963f7d28e17f72";
    private static final String MD5_MESSAGE_DEGEST_LOWERCASE = "message digest";
    private static final String MD5_MESSAGE_DEGEST_LOWERCASE_EN = "f96b697d7cb7938d525a2f31aaf161d0";
    private static final String MD5_A2Z_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String MD5_A2Z_LOWERCASE_EN = "c3fcd3d76192e4007dfb496cca67e13b";

    @Test
    public void encrypt_md5() {
        Assert.assertTrue(MD5_EMPTY_EN
            .equals(EncryptionUtil.encrypt(MD5_EMPTY, EncryptionUtil.Algorithm.MD5)));
        Assert.assertTrue(MD5_A_LOWERCASE_EN
            .equals(EncryptionUtil.encrypt(MD5_A_LOWERCASE, EncryptionUtil.Algorithm.MD5)));
        Assert.assertTrue(MD5_ABC_LOWERCASE_EN
            .equals(EncryptionUtil.encrypt(MD5_ABC_LOWERCASE, EncryptionUtil.Algorithm.MD5)));
        Assert.assertTrue(MD5_MESSAGE_DEGEST_LOWERCASE_EN
            .equals(EncryptionUtil.encrypt(MD5_MESSAGE_DEGEST_LOWERCASE, EncryptionUtil.Algorithm.MD5)));
        Assert.assertTrue(MD5_A2Z_LOWERCASE_EN
            .equals(EncryptionUtil.encrypt(MD5_A2Z_LOWERCASE, EncryptionUtil.Algorithm.MD5)));
    }

    @Test
    public void encrypt_sha1() {
        Assert.assertTrue("a9993e364706816aba3e25717850c26c9cd0d89d"
            .equals(EncryptionUtil.encrypt("abc", EncryptionUtil.Algorithm.SHA1)));
    }
}