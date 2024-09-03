package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    public WebDriver     driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
    }

    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    //Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Select Dropdown Option by Visible Text
    public void selectDropdownByText(By by, String text) {
        WebElement dropdownElement = waitVisibility(by);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(text);
    }

    // Select Dropdown Option by Value
    public void selectDropdownByValue(By by, String value) {
        WebElement dropdownElement = waitVisibility(by);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }
}