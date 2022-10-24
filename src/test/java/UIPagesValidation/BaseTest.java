package UIPagesValidation;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.TestListener;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log = LogManager.getRootLogger();
    protected JavascriptExecutor js;
    protected SoftAssert softAssert;
    protected Actions actions;
    protected LoginPage loginPage;
    protected CreatePage createPage;
    protected EditorPage editorPage;
    protected SettingsPage settingsPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        softAssert = new SoftAssert();
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        navigateTo("https://www.picsart.com/");
        loginPage = new LoginPage(driver);
        settingsPage = new SettingsPage(driver);
        createPage = loginPage.login();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    public void click(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    protected void closePopUpWindow(WebElement element) {
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();

        while (iterator.hasNext()) {
            String popUpWindow = iterator.next();

            if (!mainWindow.equalsIgnoreCase(popUpWindow)) {
                driver.switchTo().window(popUpWindow);
                click(element);
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}