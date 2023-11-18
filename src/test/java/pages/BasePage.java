package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static utilities.DriverSetup.getDriver;

public class BasePage {
    public WebDriverWait wait;
    public WebElement getElement(By locator){
        return waitForElementPresence(locator);
    }

    public void clickOnElement(By locator){
        waitForElementToBeClickable(locator);
        getElement(locator).click();
    }

    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public boolean isElementVisible(By locator){
        try {
            return getDriver().findElement(locator).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public WebElement waitForElementPresence(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectWithVisibleText(By selectLocator, String visibleText){
        Select select = new Select(getElement(selectLocator));
        select.selectByVisibleText(visibleText);
    }



}
