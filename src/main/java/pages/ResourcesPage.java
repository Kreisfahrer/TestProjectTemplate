package pages;

import base.PageBase;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static helpers.Locators.get;
import static org.testng.Assert.assertTrue;

public class ResourcesPage extends PageBase {
    private static final String TITLE = "Coherent Solutions White Paper | Content Resources | Coherent Solutions";

    private static final By PREVIEW_LINK = get("Resources.previewLink");
    private static final By IMAGE = get("Resources.previewImage");
    private static final By DESCRIPTION_IMAGE = get("Resources.descriptionImage");

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void checkPreviewResources()
    {
        ElementsCollection preview = $$(PREVIEW_LINK);
        ElementsCollection img = $$(IMAGE);
        for (int i=0;i<preview.size();i++) {
            preview.get(i).click();
            String src = $(DESCRIPTION_IMAGE).getAttribute("src");
            assertTrue(src.contains(img.get(i).getAttribute("src")));
        }

    }


}
