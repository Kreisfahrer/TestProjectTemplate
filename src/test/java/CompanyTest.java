import base.TestBase;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.Header;
import pages.TeamsPage;
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

        /*TeamsPage.getInTouch(
                "Vadim",
                "bad@email.com",
                "1234567890",
                "This is my comment, there are many like it but this one is mine"
        );

        sleep(3000);*/
    }

    @Features("Team page")
    @Stories("Check error messages")
    @Test
    public void checkGetInTouchValidation() {
        TeamsPage.inputCapthcaWithEmptyFields();
        ContactUsPage.verifyErrorMessages();
    }


}
