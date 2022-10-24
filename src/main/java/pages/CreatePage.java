package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CreatePage extends BasePage {

    @FindBy(xpath = "//button[@data-testid='create-search-button']")
    private WebElement newProjectButton;

    @FindBy(xpath = "//img[@title='User avatar']")
    private WebElement userAvatar;

    @FindBy(xpath = "//p[text()='Settings']")
    private WebElement settings;

    @FindBy(xpath = "//div[contains(@class,'createSearchSection')]")
    public WebElement designBanner;

    @FindBy(xpath = "//div[contains(@class,'buttons')]//button[@data-testid]")
    private List<WebElement> designBannerItems;

    public CreatePage(WebDriver driver) {
        super(driver);
    }

    public EditorPage startNewProject() {
        click(newProjectButton);
        return new EditorPage(driver);
    }

    public SettingsPage toSettingsPage(Actions actions) {
        wait.until(ExpectedConditions.visibilityOf(userAvatar));
        actions.moveToElement(userAvatar).perform();
        actions.moveToElement(settings).click().perform();
        return new SettingsPage(driver);
    }

    public boolean checkElementsOnTheBanner(String elementName) {
        for (WebElement item : designBannerItems) {
            if (item.getText().equals(elementName))
                return true;
        }
        return false;
    }
}