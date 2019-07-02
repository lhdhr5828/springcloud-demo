package com.lee.boot.jwt.demo.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author li.heng
 * @Date 2019/7/2 13
 * @Description:
 **/
public class Base64Utils {

    /**
     * 字符串base64编码
     * 编码UTF-8
     *
     * @param str
     * @return
     */
    public static String strEncode(String str) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = null;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytearrEncode(bytes);
    }

    public static String bytearrEncode(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode(bytes);
        String s = null;
        try {
            s = new String(encode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 字符串base64解码
     * 编码使用UTF-8
     *
     * @param encodeStr
     * @return
     */
    public static String strDecode(String encodeStr) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = null;
        try {
            bytes = encodeStr.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] decode = decoder.decode(bytes);

        String result = null;
        try {
            result = new String(decode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
