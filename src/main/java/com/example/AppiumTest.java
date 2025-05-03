package com.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.pages.HomePage;
import com.example.pages.WelcomePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AppiumTest {
    public AndroidDriver driver;
    private ExtentReports extent;
    private ExtentTest test;


    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }


    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");

        Map<String, Object> appiumOptions = new HashMap<>();
        appiumOptions.put("deviceName", "emulator-5554");
        appiumOptions.put("automationName", "UiAutomator2");
        appiumOptions.put("appPackage", "com.wallet.crypto.trustapp");
        appiumOptions.put("noReset", true);

        caps.setCapability("appium:options", appiumOptions);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

    }

    @AfterTest
    public void tearDown() {
        System.out.println("Test finished.");
        extent.flush();
    }

    @Test(priority = 1)
    public void createNewWallet() {
        test = extent.createTest("Create New Wallet Test");
        try {
            WelcomePage welcomePage = new WelcomePage(driver);
            System.out.println("Test started.");
            welcomePage.clickCreateNewWalletButton();
            welcomePage.enterPasscode("123456");
            welcomePage.enterPasscode("123456");
            welcomePage.clickSkipIllDoThisLaterButton();
            assert welcomePage.isWalletDisplayed();
            test.pass("Create New Wallet Test successful.");
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
    }

    @Test(priority = 2)
    public void renameWallet() {
        test = extent.createTest("Rename Wallet Test");
        try {
            HomePage homePage = new HomePage(driver);
            System.out.println("Test started for wallet rename");
            homePage.clickWalletDropdown();
            homePage.clickWalletDetailsIcon();
            String walletName = homePage.renameWallet();
            homePage.clickTickIcon();
            System.out.println(homePage.getWalletName());
            assert homePage.getWalletName().contains(walletName);
            test.pass("Rename wallet successful");
        } catch (Exception e) {
            test.fail(e.getMessage());

        }

    }

    @Test(priority = 3)
    public void deleteWallet() {
        test = extent.createTest("Delete Wallet Test");
        try {
            WelcomePage welcomePage = new WelcomePage(driver);
            HomePage homePage = new HomePage(driver);
            System.out.println("Test started for wallet deletion");
            homePage.clickWalletDetailsIcon();
            homePage.clickDeleteIcon();
            homePage.clickConfirmDeleteButton();
            homePage.clickProceedAnyWayButton();
            welcomePage.enterPasscode("123456");
            assert welcomePage.isCreateNewWalletButtonDisplayed();
            test.pass("Delete wallet successful");
        } catch (Exception e) {
            test.fail(e.getMessage());
        }
    }
}
