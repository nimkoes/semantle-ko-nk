package wiktionary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordExtractor {
    private static final String URL = "https://en.wiktionary.org/wiki/Wiktionary:Frequency_lists/Korean_5800";
    private static final String CLASS_NAME = "Kore";

    public static List<String> extract() throws IOException {
        List<String> words = new ArrayList<>();

        Document doc = Jsoup.connect(URL).get();
        Elements elements = doc.getElementsByClass(CLASS_NAME);

        for (Element element : elements) {
            String word = element.text();
            if (word.length() >= 2) words.add(word);
        }

        return words;
    }
}
