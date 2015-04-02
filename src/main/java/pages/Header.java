package pages;

import base.PageBase;
import org.openqa.selenium.By;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class Header extends PageBase {
    private static final By COMPANY_LINK = get("Header.companyLink");
    private static final By SERVICES_LINK = get("Header.servicesLink");
    private static final By TECHNOLOGIES_LINK = get("Header.technologiesLink");

    private static final By OUR_TEAM_MENU_ITEM = get("Header.companyMenu.ourTeam");

    public static void checkExpectedElements() {
        checkExpectedElements(Arrays.asList(
                COMPANY_LINK,
                SERVICES_LINK,
                TECHNOLOGIES_LINK
        ));
    }

    public static void goToTeamsPage() {
        $(COMPANY_LINK).hover();
        $(OUR_TEAM_MENU_ITEM).click();
        TeamsPage.shouldAppear();
    }
}
