package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAlertFilterConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author pyadav
 */
public class HawkularAlertFilterPage {

    public final WebDriver driver;
    protected static final int ALERT_CENTER_REALOAD_ITERATTIONS = 10;

    By alertCenter = HawkularAlertFilterConstants.alertCenter;
    By alertDefinitions = HawkularAlertFilterConstants.alertDefinitions;
    By clickSearchBox = HawkularAlertFilterConstants.clickSearchBox;
    By verifySeverity = HawkularAlertFilterConstants.verifySeverity;
    By verifyDescription = HawkularAlertFilterConstants.verifyDescription;

    public HawkularAlertFilterPage(WebDriver driver) {

        this.driver = driver;

    }

    public void navigateToAlertCenter() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(alertCenter);
        utils.waitForElementPresent(alertDefinitions);
        utils.navigateTo(alertDefinitions);
    }

    public void filter(String name) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(clickSearchBox, name);

    }

    public void verfiySeverity() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.waitForElementPresent(verifySeverity);

    }

    public void verifyDescription() {
        HawkularUtils utils = new HawkularUtils(driver);
        if (!driver
                .findElements(HawkularAlertFilterConstants.verifyDescription)
                .isEmpty()) {
            driver.findElement(HawkularAlertFilterConstants.verifyDescription)
                    .click();
            return;
        }
        utils.waitForElementPresent(HawkularAlertFilterConstants.nextLink);
        driver.findElement(HawkularAlertFilterConstants.nextLink).click();
        utils.waitForElementPresent(verifyDescription);
    }

    public void navigateToViewDetails() {
        HawkularUtils utils = new HawkularUtils(driver);
        if (!driver.findElements(HawkularAlertFilterConstants.viewDetailsLink)
                .isEmpty()) {
            driver.findElement(HawkularAlertFilterConstants.viewDetailsLink)
                    .click();
            return;
        }
        utils.waitForElementPresent(HawkularAlertFilterConstants.nextLink);
        driver.findElement(HawkularAlertFilterConstants.nextLink).click();
        driver.findElement(HawkularAlertFilterConstants.viewDetailsLink)
                .click();

    }

    public void navigateToAlertTab() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.waitForElementPresent(HawkularAlertFilterConstants.alertTabLink);
        driver.findElement(HawkularAlertFilterConstants.alertTabLink).click();

    }

    public void navigateToHeapUsedAlert() {
        HawkularUtils util = new HawkularUtils(driver);
        for (int i = 0; i < ALERT_CENTER_REALOAD_ITERATTIONS; i++) {
            util.refresh();
            if (!driver.findElements(
                    HawkularAlertFilterConstants.lastJvmHeapUsedAlertLocator)
                    .isEmpty()) {
                util.navigateTo(HawkularAlertFilterConstants.viewDetailsLastJvmAlertLink);
                util.waitForElementPresent(HawkularAlertFilterConstants.alertDetailPageLocator);
                return;
            }
            util.refresh();
        }
        Assert.fail();
    }

    public void acknowledgeAlert() {
        HawkularUtils util = new HawkularUtils(driver);
        driver.findElement(HawkularAlertFilterConstants.acknowledgeButton)
                .click();
        driver.findElement(HawkularAlertFilterConstants.saveButton).click();
        util.waitForElementPresent(HawkularAlertFilterConstants.acknowledgeComment);
        util.navigateTo(HawkularAlertFilterConstants.allAlertsLink);

    }

    public void verifyAcknowledgedAlert() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.waitForElementPresent(HawkularAlertFilterConstants.acknowledgeStatus);

    }

    public void ResolveAlert() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(HawkularAlertFilterConstants.viewDetailsLastJvmAlertLink);
        util.waitForElementPresent(HawkularAlertFilterConstants.alertDetailPageLocator);
        driver.findElement(HawkularAlertFilterConstants.resolveButton).click();
        driver.findElement(HawkularAlertFilterConstants.saveButton).click();
        util.waitForElementPresent(HawkularAlertFilterConstants.resolveComment);
        util.navigateTo(HawkularAlertFilterConstants.allAlertsLink);

    }

    public void verifyResolvededAlert() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(HawkularAlertFilterConstants.resolvedAlertCheckBox);
        driver.findElement(HawkularAlertFilterConstants.resolvedAlertCheckBox)
                .click();
        util.waitForElementPresent(HawkularAlertFilterConstants.resolveStatus);

    }

    public void verifyFailedDeploymentAlertExists() {
        HawkularUtils utils = new HawkularUtils(driver);
        if (!driver.findElements(
                HawkularAlertFilterConstants.failedAlertDescription).isEmpty()) {
            driver.findElement(
                    HawkularAlertFilterConstants.failedAlertDescription)
                    .click();
            return;
        }
        utils.waitForElementPresent(HawkularAlertFilterConstants.nextLink);
        driver.findElement(HawkularAlertFilterConstants.nextLink).click();
        utils.waitForElementPresent(HawkularAlertFilterConstants.failedAlertDescription);
    }

    public void verifyFailedDeploymentAlertDetails() {
        HawkularUtils utils = new HawkularUtils(driver);
        Assert.assertTrue(utils
                .waitForElementPresent(HawkularAlertFilterConstants.failedDeploymentAlertDetailsLocator));

    }

}
