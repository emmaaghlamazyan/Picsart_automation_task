package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {

    @FindBy(xpath = "//p[contains(@class,'user-avatar-description')]")
    public WebElement uploadText;

    @FindBy(id = "upload-avatar")
    public WebElement uploadButton;

    @FindBy(xpath = "//button[@data-test='save-changes-button']")
    private WebElement saveChanges;

    @FindBy(xpath = "//h1[contains(@class,'tabs-header')]")
    public WebElement settingsPageHeader;

    @FindBy(xpath = "//img[contains(@src,'data:image')]")
    public WebElement userImage;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void saveChanges() {
        click(saveChanges);
    }
}