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
public class FooterTest extends TestBase {

    @BeforeMethod
    @Override
    public void setup() {
        super.setup();
    }

    @Features("Footer")
    @Stories("Check the links on social networks")
    @Test
    public void check()
    {
        Footer.checkLinksInFooter();
    }
}
