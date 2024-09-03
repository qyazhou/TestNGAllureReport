package pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.JSErrorLogs;
import utils.logs.Log;

public class ResultPage extends BasePage {
    /**Constructor*/
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    /**Web Elements*/
    By userNameId = By.id("email");
    By passwordId = By.id("password");
    By loginButtonId = By.id("loginButton");
    By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");

    /**Page Methods*/
    public ResultPage verifyResult(String username, String password) {
        Log.info("Trying to verify result.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }

    //Verify Username Condition
    public ResultPage verifyLoginUserName(String expectedText) {
        Log.info("Verifying login username.");
        waitVisibility(errorMessageUsernameXpath);
        assertEquals(readText(errorMessageUsernameXpath), expectedText);
        return this;
    }

    //Verify Password Condition
    public ResultPage verifyLoginPassword(String expectedText) {
        Log.info("Verifying login password.");
        waitVisibility(errorMessagePasswordXpath);
        assertEquals(readText(errorMessagePasswordXpath), expectedText);
        return this;
    }

    //Verify Password Condition
    public ResultPage verifyLogError() {
        Log.info("Verifying javascript login errors.");
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));
        return this;
    }
}