package wiktionary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordExtractor {
    private final String URL = "https://en.wiktionary.org/wiki/Wiktionary:Frequency_lists/Korean_5800";

    public List<String> extract() throws IOException {
        List<String> words = new ArrayList<>();

        Document doc = Jsoup.connect(URL).get();
        Elements elements = doc.getElementsByClass("Kore");

        for (Element element : elements) {
            String word = element.text();
            if (word.length() >= 2) words.add(word);
        }

        return words;
    }

    @Deprecated
    private static boolean isKorean(String word) {
        for (char c : word.toCharArray()) {
            if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.HANGUL_SYLLABLES) return false;
        }
        return true;
    }
}
