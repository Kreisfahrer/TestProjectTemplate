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
public class ContractUsTest extends TestBase {

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        Header.goToContactUsPage();
    }

    @Features("ContractUs page")
    @Stories("Check the selection of offices")
    @Test
    public void checkSelectedOffice () throws InterruptedException
    {
        ContactUsPage.checkSlideActive("1");
        ContactUsPage.checkCityOnSlide("Minneapolis");
        ContactUsPage.clickOfficeNext();
        sleep(1000);//sleeps are added for demo, so that the tabs aren't switched too quickly
        ContactUsPage.checkSlideActive("2");
        ContactUsPage.checkCityOnSlide("New York");
        ContactUsPage.clickOfficeNext();
        sleep(1000);
        ContactUsPage.checkSlideActive("3");
        ContactUsPage.checkCityOnSlide("Boston");
        ContactUsPage.clickOfficeNext();
        sleep(1000);
        ContactUsPage.checkSlideActive("4");
        ContactUsPage.checkCityOnSlide("Minsk");
        ContactUsPage.clickOfficePrevious();
        sleep(1000);
        ContactUsPage.checkSlideActive("3");
        ContactUsPage.checkCityOnSlide("Boston");
    }
}
