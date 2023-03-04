package http;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.internal.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QueryService {
    private static final String KEY_RANK = "rank";

    public String doRequest(String url) throws IOException {

        // HTTP 연결 설정
        HttpURLConnection conn = getConnection(url);

        // API 호출 결과 읽기
        String response = getResponse(conn);

        // JSON parsing
        return getRankString(response);
    }

    private static String getRankString(String response) {
        if (StringUtil.isBlank(response)) return "";
        JsonObject jsonObj = JsonParser.parseString(response).getAsJsonObject();
        return jsonObj.get(KEY_RANK).getAsString();
    }

    private static String getResponse(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() != 200) return "";

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) response.append(inputLine);
        }

        return response.toString();
    }

    private static HttpURLConnection getConnection(String accessUrl) throws IOException {
        URL url = new URL(accessUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        return conn;
    }

}
