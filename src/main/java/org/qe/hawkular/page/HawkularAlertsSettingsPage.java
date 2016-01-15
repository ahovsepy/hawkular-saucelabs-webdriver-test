package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAlertsSettingsConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularAlertsSettingsPage {
    public final WebDriver driver;

    By allAlertsLink = HawkularAlertsSettingsConstants.allAlertsLink;
    By alertsSettingsLink = HawkularAlertsSettingsConstants.alertsSettingsLink;
    By emailField = HawkularAlertsSettingsConstants.emailField;
    By responseTimeField = HawkularAlertsSettingsConstants.responseTimeField;
    By heapGreaterThanField = HawkularAlertsSettingsConstants.heapGreaterThanField;

    public HawkularAlertsSettingsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigateToAllAlerts() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(allAlertsLink);
    }

    public void navigateToAlertsSettings() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(alertsSettingsLink);
    }

    public void verifyAllAlertsLinkPresent() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(allAlertsLink);
        Assert.assertTrue(driver.findElement(allAlertsLink).isDisplayed());
    }

    public void verifyAlertSettingsOpened() {
        verifyAlertsSettingsEmailFieldPresent();
        verifyAlertsSettingsResponseTimeFieldPresent();
    }

    public void verifyAlertsSettingsEmailFieldPresent() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(emailField);
        Assert.assertTrue(driver.findElement(emailField).isDisplayed());

    }

    public void verifyAlertsSettingsResponseTimeFieldPresent() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(responseTimeField);

    }

    public void verifyAlertsSettingsResponseEnabled() {

    }

    public void editAlertDefinition() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(HawkularAlertsSettingsConstants.heapGreaterThanField);
        driver.findElement(HawkularAlertsSettingsConstants.heapGreaterThanField)
                .clear();
        util.sendKeysTo(HawkularAlertsSettingsConstants.heapGreaterThanField,
                "60");
        driver.findElement(HawkularAlertsSettingsConstants.heapLessThanField)
                .clear();
        util.sendKeysTo(HawkularAlertsSettingsConstants.heapLessThanField, "30");
        driver.findElement(HawkularAlertsSettingsConstants.everyTimeRadioButton)
                .click();
        util.waitForElementPresent(HawkularAlertsSettingsConstants.saveButton);
        driver.findElement(HawkularAlertsSettingsConstants.saveButton).click();

    }

    public void verifyEditAlertSuccessMsg() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(HawkularAlertsSettingsConstants.editAlertSuccessMsg);

    }

    public void navigateToAllDefinitions() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(HawkularAlertsSettingsConstants.allDefinitionsLink);
        driver.findElement(HawkularAlertsSettingsConstants.allDefinitionsLink)
                .click();

    }

    public void verifyAlertSettingDetails() {
        String heapGTValue = driver.findElement(
                HawkularAlertsSettingsConstants.heapGreaterThanField)
                .getAttribute("value");
        Assert.assertEquals("60", heapGTValue);
        String heapLTValue = driver.findElement(
                HawkularAlertsSettingsConstants.heapLessThanField)
                .getAttribute("value");
        Assert.assertEquals("30", heapLTValue);
        String everyTimeSettingValue = driver.findElement(
                HawkularAlertsSettingsConstants.everyTimeRadioButton)
                .getAttribute("value");
        Assert.assertEquals("true", everyTimeSettingValue);

    }

}
