package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAlertNotificationsConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author pyadav
 */
public class HawkularAlertNotificationsPage {
	
	
	public final WebDriver driver;
	public HawkularAlertNotificationsPage(WebDriver driver) {

        this.driver = driver;

	}
	
		
	By alertNotificationLocator= HawkularAlertNotificationsConstants.alertNotificationLocator;
	By navigateAlertDefinition= HawkularAlertNotificationsConstants.navigateAlertDefinition;
	By alertDefinitionlocator= HawkularAlertNotificationsConstants.alertDefinitionlocator;
	
	
	public void verifyAlertNotification() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.waitForElementPresent(alertNotificationLocator);
        utils.waitForElementPresent(navigateAlertDefinition);
        utils.navigateTo(navigateAlertDefinition);
    }
	
	
	public void verfiyNavigationToAlertDefinition() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(alertDefinitionlocator);
		
	}
	
}
