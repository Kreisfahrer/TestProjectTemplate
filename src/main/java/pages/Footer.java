package pages;

import base.PageBase;
import com.codeborne.selenide.ElementsCollection;
import helpers.Windows;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static helpers.Locators.get;

public class Footer extends PageBase{
    private static final String TITLE_TWITTER = "Coherent Solutions (@CoherentTweets) | Твиттер";
    private static final String TITLE_FACEBOOK = "Coherent Solutions - Миннеаполис - Профессиональные услуги | Facebook";
    private static final String TITLE_LINKEDIN = "Coherent Solutions | LinkedIn";
    private static final String TITLE_GOOFLE = "Coherent Solutions – Google+";

    private static final By SOCIALNETWORK_LINKS = get("Footer.connectWithUs");

    public static void checkOpenedSocialPages(String title)
    {
        shouldAppear(title);
        Windows.closeSwitchToWindow(1);
        Windows.selectFirstWindow();
    }

    public static void checkLinksInFooter()
    {
        ElementsCollection networks = $$(SOCIALNETWORK_LINKS);
        Windows.clickAndSwitchToNewWindow(networks.get(0));
        checkOpenedSocialPages(TITLE_TWITTER);
        Windows.clickAndSwitchToNewWindow(networks.get(1));
        checkOpenedSocialPages(TITLE_FACEBOOK);
        Windows.clickAndSwitchToNewWindow(networks.get(2));
        checkOpenedSocialPages(TITLE_LINKEDIN);
        Windows.clickAndSwitchToNewWindow(networks.get(3));
        checkOpenedSocialPages(TITLE_GOOFLE);
    }
}
