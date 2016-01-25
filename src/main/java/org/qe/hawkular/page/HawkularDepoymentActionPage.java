package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularDepoymentActionPage {

	public final WebDriver driver;

	public HawkularDepoymentActionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkAllWars = HawkularRedeployConstants.checkAllWars;
	By checkFirstWarLocator = HawkularRedeployConstants.checkFirstWarLocator;
	By selectAllWarsAction = HawkularRedeployConstants.selectAllWarsAction;
	By selectWarAction = HawkularRedeployConstants.selectWarAction;
	By selectRedeployWar = HawkularRedeployConstants.selectRedeployWar;
	By verifySuccess = HawkularRedeployConstants.verifySuccess;
	By verifySucceeded = HawkularRedeployConstants.verifySucceeded;
	By selectEnableWar = HawkularRedeployConstants.selectEnableWar;
	By selectDisableWar = HawkularRedeployConstants.selectDisableWar;
	By selectRemoveWar = HawkularRedeployConstants.selectRemoveWar;
	
	public void clickWarAction() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectWarAction);
	}
	
	public void checkFirstWar() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(checkFirstWarLocator);
	}

	public void clickToRedeployAllWars() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectRedeployWar);
	}

	public void clickAllWarsAction() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(checkAllWars);
		utils.waitForElementPresent(selectWarAction);
		utils.navigateTo(selectWarAction);
		utils.waitForElementPresent(selectRedeployWar);
	}

	public void clickToRedeployWar() {

		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectRedeployWar);

	}

	public void verfiySuccess() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(verifySuccess);
//		utils.waitForElementPresent(verifySucceeded);

	}

	public void clickToEnableWar() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectEnableWar);
	}

	public void clickToDisableWar() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectDisableWar);

	}
	
	public void clickToRemoveWar() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectRemoveWar);
	}

}