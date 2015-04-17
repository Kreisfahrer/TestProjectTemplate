package pages;

import base.PageBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.Locators.get;
import static org.testng.Assert.assertTrue;

public class GetQuotePage extends PageBase {
    private static final String TITLE = "Calculate your IT project's development costs | Coherent Solutions";
    private static final String REGEXP = "\\b[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}\\b";

    private static final String NAME_ERROR_MSG = "Please provide correct Name.";
    private static final String COMPANY_ERROR_MSG = "Please provide correct Company.";
    private static final String EMAIL_ERROR_MSG = "Please provide correct E-mail.";

    private static final By ERROR_MESSAGES = get("ContactUsPage.errorMessages");
    private static final By NAME_INPUT = get("GetQuotePage.nameInput");
    private static final By COMPANY_INPUT = get("GetQuotePage.eMailInput");
    private static final By EMAIL_INPUT = get("GetQuotePage.companyInput");

    private static final By GET_IN_TOUCH_BTN = get("GetQuotePage.getInTouchButton");

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void checkExpectedElements() {
        checkExpectedElements(Arrays.asList(
                NAME_INPUT,
                EMAIL_INPUT,
                COMPANY_INPUT,
                GET_IN_TOUCH_BTN
        ));
    };

    public static void verifyErrorMessages() {
        ElementsCollection errors = $$(ERROR_MESSAGES);
        ArrayList<String> messageText = new ArrayList<>();
        for (SelenideElement error : errors) {
            messageText.add(error.getText());
        }
        if ($(NAME_INPUT).getAttribute("value").isEmpty())
            assertTrue(messageText.contains(NAME_ERROR_MSG));
        if(!$(EMAIL_INPUT).getAttribute("value").matches(REGEXP))
            assertTrue(messageText.contains(EMAIL_ERROR_MSG));
        if ($(COMPANY_INPUT).getAttribute("value").isEmpty())
            assertTrue(messageText.contains(COMPANY_ERROR_MSG));
    }

    public static void submitWithEmptyFields()
    {
        $(GET_IN_TOUCH_BTN).click();
    }

}
