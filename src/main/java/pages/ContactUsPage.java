package pages;

import base.PageBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.Locators.get;
import static org.testng.Assert.assertTrue;

public class ContactUsPage extends PageBase{
    private static final String TITLE = "Custom Software Development & Outsourcing Company | Contact Us | Coherent Solutions";
    private static final String REGEXP = "\\b[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}\\b";

    private static final String NAME_ERROR_MSG = "Please provide correct Name.";
    private static final String PHONE_ERROR_MSG = "Please provide correct Phone.";
    private static final String EMAIL_ERROR_MSG = "Please provide correct E-mail.";
    private static final String COMMENT_ERROR_MSG = "Please provide correct Comments.";
    private static final String CAPTCHA_ERROR_MSG = "Please provide correct Captcha.";

    private static final By ERROR_MESSAGES = get("ContactUsPage.errorMessages");
    private static final By NAME_INPUT = get("TeamPage.nameInput");
    private static final By EMAIL_INPUT = get("TeamPage.eMailInput");
    private static final By PHONE_INPUT = get("TeamPage.phoneInput");
    private static final By COMMENTS_INPUT = get("TeamPage.commentsInput");

    private static final By NEXT_SLIDE = get("ContactUsPage.ourOfficesSlideNext");
    private static final By PREVIOUS_SLIDE = get("ContactUsPage.ourOfficesSlidePrevious");

    private static final By ACTIVE_SLIDE = get("ContactUsPage.ourOfficesSlideActive");
    private static final By CITY_NAME = get("ContactUsPage.ourOfficesCity");


    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void checkExpectedElements() {
        checkExpectedElements(Arrays.asList(
                NAME_INPUT,
                EMAIL_INPUT,
                PHONE_INPUT,
                COMMENTS_INPUT
        ));
    }

    public static void verifyErrorMessages(String captcha) {
        ElementsCollection errors = $$(ERROR_MESSAGES);
        ArrayList<String> messageText = new ArrayList<>();
        for (SelenideElement error : errors) {
            messageText.add(error.getText());
        }
        if ($(NAME_INPUT).getAttribute("value").isEmpty())
        assertTrue(messageText.contains(NAME_ERROR_MSG));
        if($(PHONE_INPUT).getAttribute("value").isEmpty())
        assertTrue(messageText.contains(PHONE_ERROR_MSG));
        if(!$(EMAIL_INPUT).getAttribute("value").matches(REGEXP))
        assertTrue(messageText.contains(EMAIL_ERROR_MSG));
        if($(COMMENTS_INPUT).getAttribute("value").isEmpty())
        assertTrue(messageText.contains(COMMENT_ERROR_MSG));
        if (captcha.contains("incorrect"))
        assertTrue(messageText.contains(CAPTCHA_ERROR_MSG));
    }

    public static void clickOfficeNext()
    {
        $(NEXT_SLIDE).click();
        //Todo: add assertion that it loaded
    }

    public static void clickOfficePrevious()
    {
        $(PREVIOUS_SLIDE).click();
        //Todo: add assertion that it loaded
    }

    public static void checkCityOnSlide(String city)
    {
        $(CITY_NAME).has(value(city));
    }

    public static void checkSlideActive(String id)
    {
        $(ACTIVE_SLIDE).has(value(id));
    }
}
