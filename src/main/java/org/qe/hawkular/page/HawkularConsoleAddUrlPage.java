package org.qe.hawkular.page;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.base.HawkularBase;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.util.HawkularUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class HawkularConsoleAddUrlPage extends HawkularBase {

    public final WebDriver driver;
    public static String urlPageText = "Add URL";

    By consoleImageAltLocator = HawkularManagementConsolePageConstants.consoleImageAltLocator;
    By urlLocator = HawkularManagementConsolePageConstants.urlLocator;
    By addButtonLocator = HawkularManagementConsolePageConstants.addButtonLocator;
    By urlsMenuLocator = HawkularManagementConsolePageConstants.urlsMenuLocator;
    By appServersMenuLocator = HawkularManagementConsolePageConstants.appServersMenuLocator;
    By appServersListLocator = HawkularManagementConsolePageConstants.appServersListLocator;
    By urlHeadingLocator = HawkularManagementConsolePageConstants.urlHeadingLocator;
    By addUrlMsg = HawkularManagementConsolePageConstants.addUrlMsg;
    By deleteButtonLocator = HawkularManagementConsolePageConstants.deleteButtonLocator;
    By confirmDelete = HawkularManagementConsolePageConstants.confirmDelete;
    By urlTraits = HawkularManagementConsolePageConstants.urlTraits;
    By urlIPLocator = HawkularManagementConsolePageConstants.urlIPLocator;

    public HawkularConsoleAddUrlPage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean verifyConsoleImagePresent() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(consoleImageAltLocator);
    }

    public HawkularConsoleAddUrlPage typeURL(String URL) {
        driver.findElement(urlLocator).clear();
        driver.findElement(urlLocator).sendKeys(URL);

        return this;
    }

    public HawkularConsoleAddUrlPage deleteURL() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(deleteButtonLocator);
        try {
            driver.findElement(deleteButtonLocator).click();
            util.waitForElementPresent(confirmDelete);
            driver.findElement(confirmDelete).click();
        } catch (Exception e) {
        }

        return new HawkularConsoleAddUrlPage(driver);
    }

    public HawkularConsoleAddUrlPage submitURL() {
        driver.findElement(addButtonLocator).submit();
        return new HawkularConsoleAddUrlPage(driver);
    }

    public void submitURLAndWaitToBeAdded(String URL)
            throws InterruptedException, NoSuchFieldException {
        HawkularUtils util = new HawkularUtils(driver);
        driver.findElement(addButtonLocator).submit();
        util.whatForTextOnPage(URL, 60);
    }

    public boolean verifyAddUrlMsg() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(addUrlMsg);
    }

    public void verifyUrlExists() {
        HawkularUtils util = new HawkularUtils(driver);
        Assert.assertTrue(util.waitForElementPresent(urlHeadingLocator));
    }

    public void verifyUrlDoesnotExist() {
        boolean bool = true;
        try {
            driver.wait(5000);
            bool = driver.findElement(urlHeadingLocator).isDisplayed();
        } catch (Exception e) {
            bool = false;
        }
        Assert.assertFalse(bool);
    }

    public boolean urlsMenuExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(urlsMenuLocator);
    }

    public boolean appServersMenuExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServersMenuLocator);
    }

    public void navigateToAppServersMenu() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(appServersMenuLocator);
    }

    public void navigateToURLsMenu() throws InterruptedException,
            NoSuchFieldException {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(urlsMenuLocator);
        utils.whatForTextOnPage(urlPageText, 5);
    }

    public void navigateToURL() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(urlHeadingLocator);
    }

    public boolean verifyAppServersMenuNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServersListLocator);
    }

    public boolean verifyURLsMenuNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(urlLocator);
    }

    public void verifyURLTraitsExists() {
        HawkularUtils util = new HawkularUtils(driver);
        Assert.assertTrue(util.waitForElementPresent(urlIPLocator));
        WebElement URLServerTraits = driver.findElement(urlTraits);
        _logger.info("URL Server Traits are: "
                + URLServerTraits.getText());
        Assert.assertTrue(URLServerTraits.getText().contains("IP:"));
        Assert.assertTrue(URLServerTraits.getText().contains("Powered by:"));

    }

    public void addURLIfDoesNotExist(String URL) {
        if (!driver.findElements(By.linkText("http://" + URL)).isEmpty()) {

        } else {
            this.typeURL(URL);
            this.submitURL();
            // this.verifyAddUrlMsg();
        }
    }

    public void filterByName(String text) {

        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(HawkularManagementConsolePageConstants.selectNameDropdown);
        utils.navigateTo(HawkularManagementConsolePageConstants.selectNameOption);
        driver.findElement(HawkularManagementConsolePageConstants.searchbox)
                .clear();
        utils.sendKeysTo(HawkularManagementConsolePageConstants.searchbox, text);
        driver.findElement(HawkularManagementConsolePageConstants.searchbox)
                .sendKeys(Keys.RETURN);

    }

    public void VerifyfilterByName() {

        HawkularUtils utils = new HawkularUtils(driver);
        Assert.assertTrue(utils.waitForElementPresent(urlHeadingLocator));

    }

    public void filterByStateUp() {

        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(HawkularManagementConsolePageConstants.selectNameDropdown);
        utils.navigateTo(HawkularManagementConsolePageConstants.selectStateOption);
        utils.navigateTo(HawkularManagementConsolePageConstants.selectFilterByStateDropdown);
        driver.findElement(
                HawkularManagementConsolePageConstants.selectStateUpOption)
                .click();

    }

    public void verifyFilterByStateUp() {

        HawkularUtils utils = new HawkularUtils(driver);
        Assert.assertTrue(utils.waitForElementPresent(urlHeadingLocator));
        _logger.info("Test Pass Verify State Up");

    }

    public void filterByStateDown() {

        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(HawkularManagementConsolePageConstants.selectFilterByStateDropdown);
        driver.findElement(
                HawkularManagementConsolePageConstants.selectStateDownOption)
                .click();

    }

    public void VerifyFilterByStateDown() {

        HawkularUtils utils = new HawkularUtils(driver);
        Assert.assertTrue(utils
                .waitForElementPresent(HawkularManagementConsolePageConstants.url2HeadingLocator));
        _logger.info("Test Pass Verify State Down");

    }

}
