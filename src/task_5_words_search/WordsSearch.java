package task_5_words_search;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsSearch {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("popular_words.txt");
        Connection connect = Jsoup.connect("http://www.onet.pl/");

        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                String[] words = elem.text().split(" ");
                List<String> longWords = new ArrayList<>();
                for (String oneWord : words) {
                    if (oneWord.length() > 3) {
                        longWords.add(oneWord);
                    }
                }
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                Files.write(path, longWords, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> outWords = new ArrayList<>();
        outWords.add("wręcz");
        outWords.add("klub");
        outWords.add("teraz");
        outWords.add("Vital");
        outWords.add("Jest");

        try {
            Path pathFiltered = Paths.get("filtered_popular_words.txt");
            if (!Files.exists(pathFiltered)) {
                Files.createFile(pathFiltered);
            }
            Scanner scan = new Scanner(path);
            List<String> filteredWords = new ArrayList<>();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (!outWords.contains(line)) {
                    filteredWords.add(line);
                }
            }
            scan.close();
            Files.write(pathFiltered, filteredWords, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
