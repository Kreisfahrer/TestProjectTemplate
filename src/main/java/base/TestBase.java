package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    private static final String URL = "http://www.coherentsolutions.com/";

    @BeforeMethod()
    public void setup() {
        Configuration.baseUrl = URL;
        Configuration.timeout = 10000;
        open(Configuration.baseUrl);
        HomePage.shouldAppear();
    }
}
