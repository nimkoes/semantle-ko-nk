import semantle.Semantle;
import wiktionary.WordExtractor;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final int seq = 337;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(seq + "회차 꼬맨틀 풀기 시작!!");

        List<String> words = WordExtractor.extract();
        String result = new Semantle(seq, 30).process(words);

        System.out.println(seq + "회차 꼬맨틀 풀기 종료!!");
        System.out.println("정답 = " + result);
    }
}
