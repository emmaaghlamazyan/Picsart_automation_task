package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final String PWD = "Emma123456";
    private final String USERNAME = "emmaaghlamazyan94@gmail.com";

    @FindBy(xpath = "//div[@data-testid='header-authActions-sign-btn']")
    private WebElement loginOrSignUp;

    @FindBy(xpath = "//button[@aria-label='Sign in with Email']")
    private WebElement continueWithEmail;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public CreatePage login() {
        click(acceptCookies);
        click(loginOrSignUp);
        click(continueWithEmail);
        sendKeys(email, USERNAME);
        click(continueButton);
        sendKeys(password, PWD);
        click(loginButton);
        return new CreatePage(driver);
    }
}