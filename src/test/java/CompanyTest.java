import base.TestBase;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static java.lang.Thread.sleep;

@Listeners({ScreenShooter.class, BrowserPerTest.class})
public class CompanyTest extends TestBase {

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        Header.goToTeamsPage();
    }

    @Features("Team Page")
    @Stories("Show our Teams")
    @Test
    public void openTeamPage() throws InterruptedException {
        TeamsPage.checkExpectedElements();

        TeamsPage.openJavaTab();
        sleep(1000);//sleeps are added for demo, so that the tabs aren't switched too quickly
        TeamsPage.openMobileTab();
        sleep(1000);
        TeamsPage.openBITab();
        sleep(1000);
        TeamsPage.openQATab();
        sleep(1000);
        TeamsPage.openDotNetTab();
        sleep(1000);
    }

    @Features("Team page")
    @Stories("Check error messages")
    @Test
    public void checkGetInTouchValidation() {
        TeamsPage.inputCapthcaWithEmptyFields();
        ContactUsPage.verifyErrorMessages("Captcha is correct");
    }

    @Features("Team page")
    @Stories("Check error messages: Captcha is incorrect")
    @Test
    public void checkGetInTouchValidationCaptcha() {
        TeamsPage.getInTouch("Romero10",
                "romero10@email.com",
                "12345",
                "This is my comment, there are many like it but this one is mine");
        ContactUsPage.verifyErrorMessages("Captcha is incorrect");
    }

    @Features("Team page")
    @Stories("Check error messages: Email is incorrect")
    @Test
    public void checkGetInTouchValidationEmail() {
        TeamsPage.getInTouch("Romero10",
                "romero10@emailcom",
                "12345",
                "This is my comment, there are many like it but this one is mine");
        ContactUsPage.verifyErrorMessages("Captcha is incorrect");
    }
}
