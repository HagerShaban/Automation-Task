package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SwagBaseTest {
    private final WebDriver driver;
    private Wait<WebDriver> wait;
    protected By swagLabs = By.xpath("//div[normalize-space()='Swag Labs']");

    public SwagBaseTest(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15L))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
    }

    public boolean checkSwagLabsTextIsDisplayed() {
        WebElement swagLabsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(swagLabs));
        return swagLabsElement.isDisplayed();
    }

    public void returnToLoginPage() {
        driver.navigate().to("https://www.saucedemo.com/");
    }
}
