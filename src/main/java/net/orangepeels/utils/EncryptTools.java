package net.orangepeels.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptTools {
    private static final String KEY = "mother";

    private EncryptTools() {
        //私有构造方法，防止创建工具类实例
    }

    /**
     * BASE64解密,用于传递参数
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        key = new String((new BASE64Decoder()).decodeBuffer(key));
        key = key.substring(KEY.length(), key.length());
        return key.getBytes();
    }

    /**
     * BASE64加密,用于传递参数
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        String str = KEY + new String(key);
        return (new BASE64Encoder()).encodeBuffer(str.getBytes());
    }

    /**
     * 得到文件流的MD5码
     * @param file
     * @return
     */
    public static String getMD5(byte[] file) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(file);
            byte b[] = md.digest();
            int d;
            for (int i = 0; i < b.length; i++) {
                d = b[i];
                if (d < 0) {
                    d = b[i] & 0xff;
                    // 与上一行效果等同
                    // i += 256;
                }
                if (d < 16)
                    sb.append("0");
                sb.append(Integer.toHexString(d));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
