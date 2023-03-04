package semantle;

import http.QueryService;
import util.MyUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Semantle {
    private final int SEQ;
    private final int DELAY;
    private final int PRINT_PER_TRY_COUNT;

    private static final String URL = "https://semantle-ko.newsjel.ly/guess/";
    private static final String CORRECT = "정답!";
    private static final String NOT_FOUND = "찾지 못했습니다";

    public Semantle(int SEQ, int DELAY, int PRINT_PER_TRY_COUNT) {
        this.SEQ = SEQ;
        this.DELAY = DELAY;
        this.PRINT_PER_TRY_COUNT = PRINT_PER_TRY_COUNT;
    }

    public String process(List<String> words) throws IOException, InterruptedException {
        int callCount = 0, totalCount = words.size();
        for (String word : words) {
            Thread.sleep(DELAY);
            if (++callCount % PRINT_PER_TRY_COUNT == 0) System.out.println(callCount + " / " + totalCount);

            String result = QueryService.doRequest(getAccessUrl(word));
            String decodedString = MyUtil.getUTF8DecodeString(result);

            if (CORRECT.equals(decodedString)) return word;
        }

        return NOT_FOUND;
    }

    private String getAccessUrl(String word) throws UnsupportedEncodingException {
        return this.URL + this.SEQ + "/" + MyUtil.getUTF8EncodeString(word);
    }
}
