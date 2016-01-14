package org.qe.hawkular.page;

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
	
	public void navigateToViewDetails() {
        HawkularUtils utils = new HawkularUtils(driver);        
        utils.waitForElementPresent(HawkularAlertFilterConstants.viewDetailsLink);
        driver.findElement(HawkularAlertFilterConstants.viewDetailsLink).click();
        
    }   

}



