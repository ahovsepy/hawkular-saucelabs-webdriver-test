package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qe.hawkular.element.HawkularCreateCaseConstants;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;

public class HawkularCreateCasePage {

	public final WebDriver driver;

	public HawkularCreateCasePage(WebDriver driver) {
		this.driver = driver;
	}

	By clickRedHatAccess = HawkularCreateCaseConstants.clickRedHatAccess;
	By clickRedHatAccessSupport = HawkularCreateCaseConstants.clickRedHatAccessSupport;
	By clickRedHatAccessSupportOpenCase = HawkularCreateCaseConstants.clickRedHatAccessSupportOpenCase;
	By enterRedHatAccessAccount = HawkularCreateCaseConstants.enterRedHatAccessAccount;
	By clickRedHatProduct = HawkularCreateCaseConstants.clickRedHatProduct;
	By selectRedHatProduct = HawkularCreateCaseConstants.selectRedHatProduct;
	By selectRedHatProductVersion = HawkularCreateCaseConstants.selectRedHatProductVersion;
	By typeSummary = HawkularCreateCaseConstants.typeSummary;
	By writeDescription = HawkularCreateCaseConstants.writeDescription;
	By clickNext = HawkularCreateCaseConstants.clickNext;
	By clickSupportLevel = HawkularCreateCaseConstants.clickSupportLevel;
	By selectSupportLevel = HawkularCreateCaseConstants.selectSupportLevel;
	By clickSeverity = HawkularCreateCaseConstants.clickSeverity;
	By selectSeverity = HawkularCreateCaseConstants.selectSeverity;
	By clickSubmit = HawkularCreateCaseConstants.clickSubmit;




	public void clickRedHatAccess() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(clickRedHatAccess);
		driver.findElement(clickRedHatAccess).click();

		utils.waitForElementPresent(clickRedHatAccessSupport);
		driver.findElement(clickRedHatAccessSupport).click();

		utils.waitForElementPresent(clickRedHatAccessSupportOpenCase);
		driver.findElement(clickRedHatAccessSupportOpenCase).click();
	}

	public void switchFrameFocus() {
		driver.switchTo().frame("openCaseWindow");		
	} 

	public void createSupportCase() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(enterRedHatAccessAccount);
		driver.findElement(enterRedHatAccessAccount).click();
		driver.findElement(clickRedHatProduct).click();

		utils.waitForElementPresent(selectRedHatProduct);
		driver.findElement(selectRedHatProduct).click();


		utils.waitForElementPresent(selectRedHatProductVersion);
		driver.findElement(selectRedHatProductVersion).click();
	}



	public void issue(String summary, String description) {
		HawkularUtils util = new HawkularUtils(driver);
		util.sendKeysTo(typeSummary, summary);
		util.sendKeysTo(writeDescription, description);

	}


	public void nextPage() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(clickNext);
		driver.findElement(clickNext).click();
		utils.waitForElementPresent(clickSubmit);
		driver.findElement(clickSubmit).click();

	}


}
