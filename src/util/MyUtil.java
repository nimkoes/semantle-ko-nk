package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MyUtil {
    public static String getUTF8EncodeString(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8");
    }

    public static String getUTF8DecodeString(String result) throws UnsupportedEncodingException {
        return URLDecoder.decode(result, "UTF-8");
    }
}
