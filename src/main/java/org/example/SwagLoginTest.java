package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLoginTest {
    private final WebDriver driver;
    private WebDriverWait wait;
    protected By UserName = By.id("user-name");
    protected By Password = By.id("password");
    protected By LoginBtn = By.id("login-button");
    protected By ErrorMsg = By.xpath("//div[@class='error-message-container error']");
    protected By EmptyErrorMsg = By.xpath("//div[@class='error-message-container error']");

    public SwagLoginTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
    }

    public boolean usernameVisibility() {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.UserName)).isDisplayed();
    }

    public boolean passwordVisibility() {
        return this.driver.findElement(this.Password).isDisplayed();
    }

    public boolean loginBtnVisibility() {
        return this.driver.findElement(this.LoginBtn).isDisplayed();
    }

    public void enterUsername(String data) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.UserName)).sendKeys(new CharSequence[]{data});
    }

    public void enterPassword(String data) {
        this.driver.findElement(this.Password).sendKeys(new CharSequence[]{data});
    }

    public SwagBaseTest clickLoginBtn() {
        WebElement click = this.wait.until(ExpectedConditions.elementToBeClickable(this.LoginBtn));
        click.click();

        return new SwagBaseTest(this.driver);
    }

    public String getErrorMessageText() {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.ErrorMsg)).getText();
    }

    public String getEmptyFieldErrorMessage() {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.EmptyErrorMsg)).getText();
    }

    public void clearAllFields() {
        this.driver.findElement(this.UserName).clear();
        this.driver.findElement(this.Password).clear();
    }

}
