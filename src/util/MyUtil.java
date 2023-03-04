package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MyUtil {
    private static final String ENC = "UTF-8";
    public static String getUTF8EncodeString(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, ENC);
    }

    public static String getUTF8DecodeString(String result) throws UnsupportedEncodingException {
        return URLDecoder.decode(result, ENC);
    }
}
