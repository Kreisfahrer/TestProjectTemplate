import base.TestBase;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Listeners({ScreenShooter.class, BrowserPerTest.class})
public class ISsoftTest extends TestBase {

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
        HomePage.openISsoftPage();
    }

    @Features("ISsoft page")
    @Stories("Check the transition to ISsoft solutions page")
    @Test
    public void checkTransitionToISsoft()
    {
        HomePage.checkOpenedPage();
    }
}
