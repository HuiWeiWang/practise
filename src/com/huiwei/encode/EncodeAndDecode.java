package com.huiwei.encode;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncodeAndDecode {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) throws Exception {

        String msg = "hello world";
        System.out.println("加密前:" + msg);
        String encode = new BASE64Encoder().encode(msg.getBytes("utf-8"));
        System.out.println("加密后:" + encode);
        String decode = new String(new BASE64Decoder().decodeBuffer(encode), "utf-8");
        System.out.println(decode);

    }

}
