package jobflowproject.data;

import jobflowproject.model.Tag;
import jobflowproject.model.Website;
import jobflowproject.repository.JobDailyOfferRepository;
import jobflowproject.repository.TagRepository;
import jobflowproject.repository.WebsiteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataCommandLineApp implements CommandLineRunner {

    private TagRepository tagRepository;

    private WebsiteRepository websiteRepository;

    private JobDailyOfferRepository jobDailyOfferRepository;

    public DataCommandLineApp(TagRepository tagRepository, WebsiteRepository websiteRepository, JobDailyOfferRepository jobDailyOfferRepository) {
        this.tagRepository = tagRepository;
        this.websiteRepository = websiteRepository;
        this.jobDailyOfferRepository = jobDailyOfferRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Website website;
        if (!websiteRepository.findWebsite("pracuj").isPresent()) {
            website = websiteRepository.save(new Website("Pracuj", "http://pracuj.pl"));
        }

        String[] tags = {"java", "ruby", "project manager", "hr", "sprzątaczka", "programista"};
        for (String tag : tags)
            if (!tagRepository.findByName(tag).isPresent())
                tagRepository.save(new Tag(tag));
    }
}

