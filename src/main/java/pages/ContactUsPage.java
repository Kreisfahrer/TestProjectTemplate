package pages;

import base.PageBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;
import static helpers.Locators.get;
import static org.testng.Assert.assertTrue;

public class ContactUsPage extends PageBase{
    private static final String TITLE = "Custom Software Development & Outsourcing Company | Contact Us | Coherent Solutions";

    private static final String NAME_ERROR_MSG = "Please provide correct Name.";
    private static final String PHONE_ERROR_MSG = "Please provide correct Phone.";
    private static final String EMAIL_ERROR_MSG = "Please provide correct E-mail.";
    private static final String COMMENT_ERROR_MSG = "Please provide correct Comments.";

    private static final By ERROR_MESSAGES = get("ContactUsPage.errorMessages");


    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void verifyErrorMessages() {
        ElementsCollection errors = $$(ERROR_MESSAGES);
        ArrayList<String> messageText = new ArrayList<>();
        for (SelenideElement error : errors) {
            messageText.add(error.getText());
        }

        assertTrue(messageText.contains(NAME_ERROR_MSG));
        assertTrue(messageText.contains(PHONE_ERROR_MSG));
        assertTrue(messageText.contains(EMAIL_ERROR_MSG));
        assertTrue(messageText.contains(COMMENT_ERROR_MSG));
    }
}
