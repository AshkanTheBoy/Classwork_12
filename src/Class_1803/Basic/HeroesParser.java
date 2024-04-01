package Class_1803.Basic;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HeroesParser {
    private static Document document;
    private static final String url = "https://www.dotabuff.com/heroes";
    public static void main(String[] args) {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        Elements heroes = document.select(".hero");
        for (Element hero:heroes){
            String link = hero.attr("style");
            link = link.substring(16);
            System.out.println("https://www.dotabuff.com"+link);
        }
//        Elements images = document.select("html>body>div[2]>div[2]>div[3]>div[5]>section[2]>footer>div");
//        for (Element img:images){
//            System.out.println(img.attr("style"));
//        }
        ///html/body/div[2]/div[2]/div[3]/div[5]/section[2]/footer/div/a[1]/div
        ///html/body/div[2]/div[2]/div[3]/div[5]/section[2]/footer/div/a[1]/div

    }
}
