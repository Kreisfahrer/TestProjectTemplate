package pages;

import base.PageBase;
import helpers.Captcha;
import org.openqa.selenium.By;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class TeamsPage extends PageBase {
    private static final String TITLE = "Experienced Global Development Teams | Custom Application Development Company | Coherent Solutions";

    private static final By DOTNET_TAB = get("TeamPage.dotNetTab");
    private static final By JAVA_TAB = get("TeamPage.javaTab");
    private static final By MOBILE_TAB = get("TeamPage.mobileTab");
    private static final By BI_TAB = get("TeamPage.biTab");
    private static final By QA_TAB = get("TeamPage.qaTab");

    private static final By NAME_INPUT = get("TeamPage.nameInput");
    private static final By EMAIL_INPUT = get("TeamPage.eMailInput");
    private static final By PHONE_INPUT = get("TeamPage.phoneInput");
    private static final By COMMENTS_INPUT = get("TeamPage.commentsInput");
    private static final By CAPTCHA_INPUT = get("TeamPage.captchaInput");
    private static final By CAPTCHA_BLOCK = get("TeamPage.captchaBlock");
    private static final By GET_IN_TOUCH_BTN = get("TeamPage.getInTouchButton");


    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void checkExpectedElements() {
        checkExpectedElements(Arrays.asList(
                DOTNET_TAB,
                JAVA_TAB,
                MOBILE_TAB,
                BI_TAB,
                QA_TAB
        ));
    }

    public static void openDotNetTab() {
        $(DOTNET_TAB).click();
        //Todo: add assertion that it loaded
    }

    public static void openJavaTab() {
        $(JAVA_TAB).click();
        //Todo: add assertion that it loaded
    }

    public static void openMobileTab() {
        $(MOBILE_TAB).click();
        //Todo: add assertion that it loaded
    }

    public static void openBITab() {
        $(BI_TAB).click();
        //Todo: add assertion that it loaded
    }

    public static void openQATab() {
        $(QA_TAB).click();
        //Todo: add assertion that it loaded
    }

    public static void getInTouch(String name, String email, String phone, String comment) {
        $(NAME_INPUT).sendKeys(name);
        $(EMAIL_INPUT).sendKeys(email);
        $(PHONE_INPUT).sendKeys(phone);
        $(COMMENTS_INPUT).sendKeys(comment);
        $(CAPTCHA_INPUT).sendKeys((Integer.parseInt(Captcha.getCaptchaResult($(CAPTCHA_BLOCK).getText())) + 1)+"");
        $(GET_IN_TOUCH_BTN).click();
        ContactUsPage.shouldAppear();
    }

    public static void inputCapthcaWithEmptyFields() {
        $(CAPTCHA_INPUT).sendKeys(Captcha.getCaptchaResult($(CAPTCHA_BLOCK).getText()));
        $(GET_IN_TOUCH_BTN).click();
        ContactUsPage.shouldAppear();
    }
}
