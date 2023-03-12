import semantle.Semantle;
import wiktionary.WordExtractor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    private static final int DELAY_MILLI = 20;
    private static final int PRINT_PER_TRY_COUNT = 25;

    public static void main(String[] args) throws IOException, InterruptedException {
        long seq = getSeq();
        System.out.println(seq + "회차 꼬맨틀 풀기 시작!!");
        String result = new Semantle(seq, DELAY_MILLI, PRINT_PER_TRY_COUNT).process(WordExtractor.extract());
        System.out.println("정답 [" + result + "]");
    }

    private static long getSeq() {
        return ChronoUnit.DAYS.between(LocalDate.of(2022, 4, 1), LocalDate.now());
    }
}
