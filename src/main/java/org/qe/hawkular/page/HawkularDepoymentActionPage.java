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

	By selectAllWarsAction = HawkularRedeployConstants.selectAllWarsAction;
	By selectFirstWarAction = HawkularRedeployConstants.selectFirstWarAction;
	By selectRedeployWar = HawkularRedeployConstants.selectRedeployWar;
	By verifySuccess = HawkularRedeployConstants.verifySuccess;
	By verifySucceeded = HawkularRedeployConstants.verifySucceeded;
	By selectEnableWar = HawkularRedeployConstants.selectEnableWar;
	By selectDisableWar = HawkularRedeployConstants.selectDisableWar;
	By selectRemoveWar = HawkularRedeployConstants.selectRemoveWar;
	
	public void clickFirstWarAction() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectAllWarsAction);
		utils.waitForElementPresent(selectRedeployWar);
	}

	public void clickToRedeployAllWars() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectRedeployWar);
	}

	public void clickAllWarsAction() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectAllWarsAction);
		utils.waitForElementPresent(selectRedeployWar);
	}

	public void clickToRedeployFirstWar() {

		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectRedeployWar);

	}

	public void verfiySuccess() {
		// TODO - verify via Current State (the message may be generated but it doesnt necessary mean that it was successful (ex. disable all - msg OK, but server shut down and 404). 
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(verifySuccess);
		utils.waitForElementPresent(verifySucceeded);

	}

	public void clickToEnableWar() {

		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectEnableWar);
	}

	public void clickToDisableFirstWar() {

		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectDisableWar);

	}
	
	public void clickToRemoveWar() {

		HawkularUtils utils = new HawkularUtils(driver);
		utils.navigateTo(selectRemoveWar);
	}

}