package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAppServerPageConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularAppServerPage {

    public final WebDriver driver;

    public HawkularAppServerPage(WebDriver driver) {
        this.driver = driver;
    }

    By localAppServerLink = HawkularAppServerPageConstants.localWildfyServerLink;
    By appServerJvmtabLocator = HawkularAppServerPageConstants.appServerJvmtabLocator;
    By appServerOverviewtabLocator = HawkularAppServerPageConstants.appServerOverviewtabLocator;
    By appServerJVMtabLink = HawkularAppServerPageConstants.appServerJVMtabLink;
    By appServerDatasourcestabLink = HawkularAppServerPageConstants.appServerDatasourcestabLink;
    By appServerDeploymentstabLink = HawkularAppServerPageConstants.appServerDeploymentsLink;
    By appServerDeploymentstabLocator = HawkularAppServerPageConstants.appServerDeploymentstabLocator;
    By appServerWarFileLocator = HawkularAppServerPageConstants.appServerWarFileLocator;
    By appServerRHALocator = HawkularAppServerPageConstants.appServerRHALocator;
    By appServerRHASearchLocator = HawkularAppServerPageConstants.appServerRHASearchLocator;
        
    public void verifyLocalAppServerExists() {
        HawkularUtils util = new HawkularUtils(driver);
        Assert.assertTrue(util.waitForElementPresent(localAppServerLink));
    }

    public void navigateToLocalAppServer() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(localAppServerLink);
    }

    public boolean verifyAppServerJVMTabNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServerJvmtabLocator);
    }
    
    public boolean verifyAppServerOverviewTabNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServerOverviewtabLocator);
    }
    
    public void navigateToJVMTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerJVMtabLink);
    }

    public void navigateToDeploymentsTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerDeploymentstabLink);
    }

    public void navigateToDatasourcesTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerDatasourcestabLink);
    }

    public boolean verifyAppServerDeploymentsTabNavigation() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServerDeploymentstabLocator);
    }

    public boolean verifyAppServerWarExists() {
        HawkularUtils util = new HawkularUtils(driver);
        return util.waitForElementPresent(appServerWarFileLocator);
    }

    public void navigateToRHATab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerRHALocator);
    }

    public void navigateToRHASearchTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(appServerRHASearchLocator);
    }
}
