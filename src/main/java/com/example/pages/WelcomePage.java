package com.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WelcomePage extends BasePage {
    private final By newWalletButton = By.xpath("//android.view.View[@resource-id=\"CreateNewWalletButton\"]/android.widget.Button");
    private final By skipIllDoLaterButton = By.xpath("//android.widget.TextView[@text=\"Skip, I'll do it later\"]");
    private final By walletBalanceLabel = By.xpath("//android.widget.TextView[@resource-id=\"mainBalance\"]");

    public WelcomePage(AndroidDriver driver) {
        super(driver);
    }

    public void clickCreateNewWalletButton() {
        waitForElementToBeDisplayed(newWalletButton).click();
    }

    public boolean isCreateNewWalletButtonDisplayed() {
        return waitForElementToBeDisplayed(newWalletButton).isDisplayed();
    }

    public void enterPasscode(String passcode) {
        for (char digit : passcode.toCharArray()) {
            By by = By.xpath("//android.widget.TextView[@text='" + digit + "']");
            waitForElementToBeDisplayed(by).click();
        }
    }
    public void clickSkipIllDoThisLaterButton() {
        waitForElementToBeDisplayed(skipIllDoLaterButton).click();
    }
    public boolean isWalletDisplayed(){
        return waitForElementToBeDisplayed(walletBalanceLabel).isDisplayed();
    }
}
