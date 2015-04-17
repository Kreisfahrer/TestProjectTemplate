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
    private static final By APPROACH_LINK = get("Header.approachLink");
    private static final By BLOG_LINK = get("Header.blogLink");
    private static final By CONTACTUS_LINK = get("Header.contactUsLink");

    private static final By OUR_TEAM_MENU_ITEM = get("Header.companyMenu.ourTeam");
    private static final By GET_QUOTE_MENU_ITEM = get("Header.contactUsLink.getQuote");
    private static final By NEWS_ITEM = get("Header.companyMenu.news");
    private static final By RESOURCES_ITEM = get("Header.blog.resources");

    private static final By BREADCRUMBS_LINK = get("Header.breadcrumbsLink");

    public static void checkExpectedElements() {
        checkExpectedElements(Arrays.asList(
                COMPANY_LINK,
                SERVICES_LINK,
                TECHNOLOGIES_LINK,
                APPROACH_LINK,
                BLOG_LINK,
                CONTACTUS_LINK
        ));
    }

    public static void goToTeamsPage() {
        $(COMPANY_LINK).hover();
        $(OUR_TEAM_MENU_ITEM).click();
        TeamsPage.shouldAppear();
    }

    public static void goToContactUsPage() {
        $(CONTACTUS_LINK).click();
        ContactUsPage.shouldAppear();
    }

    public static void goToGetQuotePage() {
        $(CONTACTUS_LINK).hover();
        $(GET_QUOTE_MENU_ITEM).click();
        GetQuotePage.shouldAppear();
    }

    public static void goToNewsPage()
    {
        $(COMPANY_LINK).hover();
        $(NEWS_ITEM).click();
        NewsPage.shouldAppear();
    }

    public static void goToOurApproachPage() {
        $(APPROACH_LINK).click();
        OurApproachPage.shouldAppear();
    }

    public static void goToResourcesPage() {
        $(BLOG_LINK).hover();
        $(RESOURCES_ITEM).click();
        ResourcesPage.shouldAppear();
    }

    public static void checkOpenedPagesInHeader()
    {
        $(COMPANY_LINK).click();
        $(BREADCRUMBS_LINK).getAttribute("href").contains("company-overview");
        $(SERVICES_LINK).click();
        $(BREADCRUMBS_LINK).getAttribute("href").contains("our-services");
        $(TECHNOLOGIES_LINK).click();
        $(BREADCRUMBS_LINK).getAttribute("href").contains("java-development");
        $(APPROACH_LINK).click();
        $(BREADCRUMBS_LINK).getAttribute("href").contains("our-approach");
        $(BLOG_LINK).click();
        $(BREADCRUMBS_LINK).getAttribute("href").contains("blog");
        $(CONTACTUS_LINK).click();
        $(BREADCRUMBS_LINK).getAttribute("href").contains("contact-coherent-solutions");
    }
}
