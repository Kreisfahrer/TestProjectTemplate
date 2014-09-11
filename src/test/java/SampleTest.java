import base.TestBase;
import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;

@Listeners({ScreenShooter.class, BrowserPerTest.class})
public class SampleTest extends TestBase {
//    Sample code
//    private static final String ROOM_FOR_TESTS = "Created for testing";
//    private static final String TEST_FOLDER_NAME = "TestQA";
//
//
//    @Override
//    @BeforeMethod()
//    public void setup() throws MalformedURLException {
//        super.setup();
//        open(Configuration.baseUrl);
//    }
//
//    @Test
//    public void downloadMultiplyFilesTest() throws Exception {
//        LoginPage.login(OBSERVER);
//        HomePage.shouldAppear();
//        HomePage.openRoom(ROOM_FOR_TESTS);
//        RoomPage.shouldAppear();
//        RoomPage.getFolder(TARGET_FOLDER).click();
//        RoomPage.selectAll();
//        RoomPage.download();
//        RoomPage.waitForCreating();
//        RoomPage.saveArchive();
//        RoomPage.getArchiveContent();
//        RoomPage.getFoldersContent(TARGET_FOLDER);
//        RoomPage.checkContent();
//    }
}
