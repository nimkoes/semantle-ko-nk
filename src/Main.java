import semantle.Semantle;
import wiktionary.WordExtractor;

import java.io.IOException;

public class Main {
    private static final int SEQ = 337;
    private static final int DELAY_MILLI = 30;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(SEQ + "회차 꼬맨틀 풀기 시작!!");
        String result = new Semantle(SEQ, DELAY_MILLI).process(WordExtractor.extract());
        System.out.println(SEQ + "회차 꼬맨틀 풀기 종료!!");
        System.out.println("정답 = " + result);
    }
}
