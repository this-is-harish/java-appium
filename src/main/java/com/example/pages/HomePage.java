package com.example.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By walletIcon = By.xpath("//android.widget.TextView[@resource-id=\"topBarWalletName\"]");
    private final By walletDetailsIcon = By.xpath("//android.view.View[@resource-id=\"walletDetailsIconButton\"]");
    private final By walletNameField = By.xpath("//android.widget.EditText[@resource-id=\"walletNameField\"]");
    private final By tickIcon = By.xpath("//android.view.View[@resource-id=\"toolbar\"]/android.widget.Button[2]");
    private final By walletName = By.xpath("//android.view.View[@resource-id=\"walletRow\"]");
    private final By deleteIcon = By.xpath("//android.widget.Button[@resource-id=\"deleteWalletButton\"]");
    private final By confirmDeleteButton = By.xpath("//android.widget.TextView[@text=\"Delete\"]");
    private final By proceedAnyWayButton = By.xpath("//android.widget.TextView[@resource-id=\"secondaryAction\"]");


    public HomePage(AndroidDriver driver) {
        super(driver);
    }
    public void clickWalletDropdown() {
        waitForElementToBeDisplayed(walletIcon).click();
    }
    public void clickWalletDetailsIcon() {
        waitForElementToBeDisplayed(walletDetailsIcon).click();
    }
    public String renameWallet() {
        String walletName = "Test Wallet Renamed";
        waitForElementToBeDisplayed(walletNameField).clear();
        waitForElementToBeDisplayed(walletNameField).sendKeys(walletName);
        return walletName;
    }

    public void clickTickIcon() {
        waitForElementToBeDisplayed(tickIcon).click();
    }

    public String getWalletName() {
        return waitForElementToBeDisplayed(walletName).getText();
    }

    public void clickDeleteIcon() {
        waitForElementToBeDisplayed(deleteIcon).click();
    }
    public void clickConfirmDeleteButton() {
        waitForElementToBeDisplayed(confirmDeleteButton).click();
    }

    public void clickProceedAnyWayButton() {
        waitForElementToBeDisplayed(proceedAnyWayButton).click();
    }

}
