package wiktionary;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class WordExtractor {
    private static final String URL = "https://en.wiktionary.org/wiki/Wiktionary:Frequency_lists/Korean_5800";
    private static final String CLASS_NAME = "Kore";

    public static List<String> extract() throws IOException {
        Document doc = Jsoup.connect(URL).get();
        Elements elements = doc.getElementsByClass(CLASS_NAME);

        return elements.stream()
                .filter(elem -> elem.text().length() >= 2)
                .map(elem -> elem.text())
                .collect(Collectors.toList());
    }
}
