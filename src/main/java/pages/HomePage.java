package pages;

import base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchToWindow;
import static helpers.Locators.get;

public class HomePage extends PageBase {
    private static final String TITLE = "Software Development Outsourcing. Offshore Software Development Company | Coherent Solutions";
    private static final String TITLE_ISSOFT = "ISsoft -работа для IT специалистов в Минске";

    private static final By LOGO_HREF = get("HomePage.companyLogo");

    public static void shouldAppearISsoft() {shouldAppear(TITLE_ISSOFT);}
    public static void shouldAppear() {shouldAppear(TITLE);}

    public static void openISsoftPage()
    {
        $(LOGO_HREF).click();
        //Todo: add assertion that it loaded
    }


    public static void checkOpenedPage()
    {
        switchToWindow(TITLE_ISSOFT);
        shouldAppearISsoft();
    }

}
