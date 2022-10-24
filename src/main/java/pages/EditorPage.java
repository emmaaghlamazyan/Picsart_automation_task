package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditorPage extends BasePage {
    @FindBy(id = "layout-category")
    public WebElement layout;

    @FindBy(css = "svg[data-testid='center-icon']")
    public WebElement popUpCloseButton;

    @FindBy(id = "editor-sidebar")
    public WebElement editorPageSidebar;

    public EditorPage(WebDriver driver) {
        super(driver);
    }
}