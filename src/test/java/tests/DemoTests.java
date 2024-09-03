package tests;

import static utils.extentreports.ExtentTestManager.startTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.lang.reflect.Method;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.listeners.TestListener;

//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Demo Tests")
public class DemoTests extends BaseTest {
    @Test(priority = 0, description = "Valid Demo Scenario with right postzip and building name.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Demo test with right postzip and building name.")
    @Story("Valid postzip and building name demo test")
    public void validDemoTest_ValidData(Method method) {
        startTest(method.getName(), "Valid Demo Scenario with right postzip and building name.");

        homePage
            .goToHomepage()
            .inputDataToHomePage()
            .goToResultpage()
            .verifyResult("", "")
            .verifyLogError();
    }

//    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test Description: Login test with empty username and empty password.")
//    @Story("Empty username and password login test")
//    public void invalidDemoTest_InvalidData(Method method) {
//        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
//
//        homePage
//            .goToHomepage()
//            .goToResultpage()
//            .loginToN11("", "")
//            .verifyLoginUserName("Lütfen e-posta adresinizi girin.")
//            .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
//    }
}