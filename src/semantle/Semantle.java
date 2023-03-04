package semantle;

import http.QueryService;
import util.MyUtil;

import java.io.IOException;
import java.util.List;

public class Semantle {
    private final int seq;
    private final int delay;
    private static final String URL = "https://semantle-ko.newsjel.ly/guess/";
    private static final String CORRECT = "정답!";


    public Semantle(int seq, int delay) {
        this.seq = seq;
        this.delay = delay;
    }

    public void process(List<String> words) throws IOException, InterruptedException {
        String url = getAccessUrl();
        QueryService queryService = new QueryService();

        int callCount = 0, totalCount = words.size();
        for (String word : words) {
            // 천천히 요청하도록...
            Thread.sleep(delay);
            String result = queryService.doRequest(url + MyUtil.getUTF8EncodeString(word));
            String decodedString = MyUtil.getUTF8DecodeString(result);

            ++callCount;
            if (callCount % 100 == 0) {
                System.out.println(callCount++ + " / " + totalCount);
            }

            if (CORRECT.equals(decodedString)) {
                System.out.println(callCount + "번째 단어 [" + word + "] 가 정답");
                break;
            }
        }
    }

    private String getAccessUrl() {
        return this.URL + this.seq + "/";
    }
}
