package com.jgp.base64.BaseTest;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: hsjytest
 * @Package: com.jgp.base64.BaseTest
 * @ClassName: BasePad
 * @Description: java类作用描述
 * @Author: 焦关平
 * @CreateDate: 2018/8/15 19:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/8/15 19:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BasePad {
    public static void main(String[] args) throws IOException {

        final BASE64Encoder encoder = new BASE64Encoder();
        final BASE64Decoder decoder = new BASE64Decoder();
        final String text = "字串文字";
        final byte[] textByte = text.getBytes("UTF-8");
//编码
        final String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);
//解码
        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
    }
}
