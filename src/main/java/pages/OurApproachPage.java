package pages;

import base.PageBase;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class OurApproachPage extends PageBase {
    private static final String TITLE = "Expertise in Commercial Grade Software Development | Our Approach | Coherent Solutions";

    private static final By PDF_DOWNLOAD = get("OurApproach.pdfDownloadLink");

    public static void shouldAppear() {
        shouldAppear(TITLE);
    }

    public static void checkExpectedElements() {
        checkExpectedElements(Arrays.asList(
                PDF_DOWNLOAD
        ));
    }

    public static void downloadPDF(){
        try {
            $(PDF_DOWNLOAD).download();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
