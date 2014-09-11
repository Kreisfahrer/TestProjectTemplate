package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    private static final String URL = "";

    @BeforeMethod()
    public void setup() {
        Configuration.baseUrl = URL;
        Configuration.timeout = 10000;
    }
}
