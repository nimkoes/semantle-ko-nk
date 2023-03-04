import semantle.Semantle;
import wiktionary.WordExtractor;

import java.io.IOException;

public class Main {
    private static final int SEQ = 337;
    private static final int DELAY_MILLI = 30;
    private static final int PRINT_PER_TRY_COUNT = 50;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(SEQ + "회차 꼬맨틀 풀기 시작!!");
        String result = new Semantle(SEQ, DELAY_MILLI, PRINT_PER_TRY_COUNT).process(WordExtractor.extract());
        System.out.println("정답 [" + result + "]");
    }
}
