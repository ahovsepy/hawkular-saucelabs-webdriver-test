package org.qe.hawkular.page;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.hawkularAlertSeverityFilterConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author pyadav
 */
public class hawkularAlertSeverityFilterPage {

	
	public final WebDriver driver;
	
	
	
	By alertCenter = hawkularAlertSeverityFilterConstants.alertCenter;
	By alertDefinitions = hawkularAlertSeverityFilterConstants.alertDefinitions;
	By clickSearchBox = hawkularAlertSeverityFilterConstants.clickSearchBox;
	By verifySeverity = hawkularAlertSeverityFilterConstants.verifySeverity;
	By verifyDescription = hawkularAlertSeverityFilterConstants.verifyDescription;
	
	
	
	public hawkularAlertSeverityFilterPage(WebDriver driver) {

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
        util.sendKeysTo(clickSearchBox,name);        

	}
	
	public void verfiySeverity() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(verifySeverity);
		
	}
	
	
	public void verifyDescription() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(verifyDescription);
		
	}	

}



