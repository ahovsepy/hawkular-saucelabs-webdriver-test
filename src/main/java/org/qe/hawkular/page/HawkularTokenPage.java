package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularTokenConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularTokenPage {
	public final WebDriver driver;

	public HawkularTokenPage(WebDriver driver) {

	    this.driver = driver;

	}
	
	By clickUser= HawkularTokenConstants.clickUser;
	By clickTokens= HawkularTokenConstants.clickTokens;
	By clickCreateToken= HawkularTokenConstants.clickCreateToken;
	By clickDeleteToken= HawkularTokenConstants.clickDeleteToken;
	By clickRevoke= HawkularTokenConstants.clickRevoke;
	
public void createToken(){
		
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(clickUser);
		utils.waitForElementPresent(clickTokens);
		utils.navigateTo(clickTokens);
		utils.waitForElementPresent(clickCreateToken);
		utils.navigateTo(clickCreateToken);
}

public void deleteToken(){
	
	HawkularUtils utils = new HawkularUtils(driver);
	
	utils.navigateTo(clickUser);
	utils.waitForElementPresent(clickTokens);
	utils.navigateTo(clickTokens);
	utils.waitForElementPresent(clickDeleteToken);
	utils.navigateTo(clickDeleteToken);
	utils.waitForElementPresent(clickRevoke);
	utils.navigateTo(clickRevoke);
}


}
