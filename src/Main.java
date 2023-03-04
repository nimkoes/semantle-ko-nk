import semantle.Semantle;
import wiktionary.WordExtractor;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final int seq = 337;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(seq + "회차 꼬맨틀 풀기 시작!!");

        WordExtractor wordExtractor = new WordExtractor();
        List<String> words = wordExtractor.extract();

        Semantle semantle = new Semantle(seq, 30);
        String result = semantle.process(words);

        System.out.println(seq + "회차 꼬맨틀 풀기 종료!!");
        System.out.println("정답 = " + result);
    }
}
