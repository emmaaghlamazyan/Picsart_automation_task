package UIPagesValidation;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.RetryAnalyzer;

import java.util.ArrayList;

public class EditorTest extends BaseTest {

    private final String EDITOR_PAGE_URL = "https://picsart.com/create/editor?category=layout&customSize=1080x1080&unit=px";

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testEditorLayout() {
        log.info("Check design banner on Create page");
        wait.until(ExpectedConditions.visibilityOf(createPage.designBanner));
        softAssert.assertTrue(createPage.designBanner.isDisplayed(), "New design banner is visible");

        log.info("Check buttons in the design banner");
        softAssert.assertTrue(createPage.checkElementsOnTheBanner("+ New project"));
        softAssert.assertTrue(createPage.checkElementsOnTheBanner("Upload"));

        log.info("Click on “New Project” button");
        editorPage = createPage.startNewProject();

        log.info("Navigate to Editor page");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.urlContains("editor"));
        softAssert.assertEquals(driver.getCurrentUrl(), EDITOR_PAGE_URL);
        closePopUpWindow(editorPage.popUpCloseButton);

        log.info("Verify Default category is Layout");
        wait.until(ExpectedConditions.visibilityOf(editorPage.editorPageSidebar));
        softAssert.assertTrue(editorPage.layout.getAttribute("className").contains("active"));

        softAssert.assertAll();
    }
}