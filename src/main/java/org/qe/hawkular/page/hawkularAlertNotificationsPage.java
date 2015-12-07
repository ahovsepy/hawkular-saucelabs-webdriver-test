package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.hawkularAlertNotificationsConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author pyadav
 */
public class hawkularAlertNotificationsPage {
	
	
	public final WebDriver driver;
	public hawkularAlertNotificationsPage(WebDriver driver) {

        this.driver = driver;

	}
	
	
	
	By clickApplicationServer= hawkularAlertNotificationsConstants.clickApplicationServer;
	By clickAppServer= hawkularAlertNotificationsConstants.clickAppServer;
	By verifyAlert= hawkularAlertNotificationsConstants.verifyAlert;
	By nevigateDefinition= hawkularAlertNotificationsConstants.nevigateDefinition;
	By verifyDefinition= hawkularAlertNotificationsConstants.verifyDefinition;
	
	
	public void navigateToAppServer() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(clickApplicationServer);
        utils.waitForElementPresent(clickAppServer);
        utils.navigateTo(clickAppServer);
    }	
	
	
	public void verifyAlert() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.waitForElementPresent(verifyAlert);
        utils.waitForElementPresent(nevigateDefinition);
        utils.navigateTo(nevigateDefinition);
    }
	
	
	public void verfiySeverity() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(verifyDefinition);
		
	}
	
}
