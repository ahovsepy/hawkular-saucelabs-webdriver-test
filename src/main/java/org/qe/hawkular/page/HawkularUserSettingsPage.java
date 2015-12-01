package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author skondkar
 */
public class HawkularUserSettingsPage {

    public final WebDriver driver;

    public HawkularUserSettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    By accountsDropdown = HawkularLoginPageConstants.logoutDropdown;
    By userSettingsLink = HawkularUserSettingsConstants.userSettingsLink;
    String userEmail = HawkularUserSettingsConstants.userEmail;
    By emailFieldLocator = HawkularUserSettingsConstants.emailFieldLocator;
    By saveButtonLocator = HawkularUserSettingsConstants.saveButtonLocator;
    By verifySuccessMsg = HawkularUserSettingsConstants.verifySuccessMsg;
    

    public void navigateToUserSettings() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(accountsDropdown);
        util.navigateTo(userSettingsLink);
    }

    public void addEmailNotification() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(emailFieldLocator);
        driver.findElement(HawkularUserSettingsConstants.emailFieldLocator).clear();
        util.sendKeysTo(emailFieldLocator, userEmail);
        util.navigateTo(saveButtonLocator);
        util.waitForElementPresent(verifySuccessMsg);
    }    

}