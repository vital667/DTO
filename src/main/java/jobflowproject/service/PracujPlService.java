package jobflowproject.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PracujPlService {

    public Integer getNumberOfJobs(String tagName, String city) throws IOException {
        String url = "https://www.pracuj.pl/praca/" + tagName + ";kw/" + city + ";wp?rd=30";
        String numberText = Jsoup.connect(url).get().getElementsByClass("results-header__offer-count-text-number").first().text();
        return Integer.parseInt(numberText);
    }
}
