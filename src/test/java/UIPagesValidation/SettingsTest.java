package UIPagesValidation;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

public class SettingsTest extends BaseTest {

    private final String IMG_PATH = "C:\\Users\\Emma_Aghlamazyan\\Downloads\\img.jpg";

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testUserAvatarUpload() {
        log.info("Hover on the user avatar and click on the Settings item");
        createPage.toSettingsPage(actions);
        wait.until(ExpectedConditions.visibilityOf(settingsPage.uploadText));
        softAssert.assertTrue(settingsPage.settingsPageHeader.getText().equals("Settings"));

        log.info("Verify message under upload button");
        softAssert.assertTrue(settingsPage.uploadText.getText().equals(
                "You can upload jpg. or png image files. Max size 2mb."));

        log.info("Click upload button and upload image from PC");
        settingsPage.uploadButton.sendKeys(IMG_PATH);
        settingsPage.saveChanges();
        softAssert.assertTrue((Boolean) (js.executeScript
                ("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                        settingsPage.userImage)));

        softAssert.assertAll();
    }
}