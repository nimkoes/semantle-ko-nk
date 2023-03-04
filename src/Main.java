import semantle.Semantle;
import wiktionary.WordExtractor;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        WordExtractor wordExtractor = new WordExtractor();
        List<String> words = wordExtractor.extract();

        Semantle semantle = new Semantle(337, 50);
        semantle.process(words);
    }
}
