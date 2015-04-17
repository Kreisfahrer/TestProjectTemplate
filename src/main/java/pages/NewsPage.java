package pages;

import base.PageBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$$;
import static helpers.Locators.get;
import static org.testng.Assert.assertTrue;

public class NewsPage extends PageBase {
    private static final String TITLE = "News | Coherent Solutions";
    private static final By DATE_LABEL = get("NewsPage.dateLabel");

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void verifySequenceDate() {
        ElementsCollection dates = $$(DATE_LABEL);
        ArrayList<String> dateText = new ArrayList<>();
        for (SelenideElement date : dates) {
            dateText.add(date.getText());
        }

        for (int i = 0; i < dateText.size()-1; i++)
        {
            assertTrue(convertStringToDate(dateText.get(i)).getTime() > convertStringToDate(dateText.get(i + 1)).getTime());
        }

    }

    public static Date convertStringToDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate localdate = LocalDate.parse(date, formatter);
        Instant instant = localdate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date_ = Date.from(instant);
        return date_;
    }
}

