package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.logs.Log;

public class HomePage extends BasePage {
    /**
     * Constructor
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "https://www.nuro.jp/app/nurohikari-directolsu-mansion/area/#building-input";

    /**
     * Web Elements
     */
    By inputZip = By.id("input-zip");
    By searchZip = By.id("search-zip");
    By townList = By.id("town-list");
    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage goToHomepage() {
        Log.info("Opening Website.");
        driver.get(baseURL);
        return this;
    }

    //input data to Homepage
    public HomePage inputDataToHomePage() {
        Log.info("Input data to Home Page..");
        writeText(inputZip, "1750082");
        click(searchZip);
        waitVisibility(townList);
        //click(townList);
        //selectDropdownByText(townList, "高島平４丁目");
        return this;
    }

    //Go to ResultPage
    public ResultPage goToResultpage() {
        Log.info("Going to Result Page..");
        return new ResultPage(driver);
    }
}