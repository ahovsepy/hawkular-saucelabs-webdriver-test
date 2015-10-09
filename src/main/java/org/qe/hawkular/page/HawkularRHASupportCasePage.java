package org.qe.hawkular.page;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularRHASupportCaseConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularRHASupportCasePage {

	public final WebDriver driver;

	public HawkularRHASupportCasePage(WebDriver driver) {
		this.driver = driver;
	}


	By rhAccessDropdownLocator = HawkularRHASupportCaseConstants.rhAccessDropdownLocator;
	By rhAccessSupportLocator = HawkularRHASupportCaseConstants.rhAccessSupportLocator;
	By rhSupportmyCasesLocator = HawkularRHASupportCaseConstants.rhSupportmyCasesLocator;
	By selectStatusOpenandClosed = HawkularRHASupportCaseConstants.selectStatusOpenandClosed;
	By rhAccessStatusDropdownLocator = HawkularRHASupportCaseConstants.rhAccessStatusDropdownLocator;
	By verifyTicket = HawkularRHASupportCaseConstants.verifyTicket;
	By supportCaseIDLocator = HawkularRHASupportCaseConstants.supportCaseIDLocator;
	By supportCaseDetailsLocator = HawkularRHASupportCaseConstants.supportCaseDetailsLocator;
	By rhAccessCaseSearchFieldLocator = HawkularRHASupportCaseConstants.rhAccessCaseSearchFieldLocator;
	By searchResultLocator = HawkularRHASupportCaseConstants.searchResultLocator;


	public void navigateToRHATab() {
		HawkularUtils util = new HawkularUtils(driver);
		util.navigateTo(rhAccessDropdownLocator);
	}

	public void navigateToRHASupportmyCasesTab() {
		HawkularUtils util = new HawkularUtils(driver);
		util.navigateTo(rhAccessSupportLocator);
		util.navigateTo(rhSupportmyCasesLocator);
	}

	public void searchOpenTickets(String text) {
		HawkularUtils util = new HawkularUtils(driver);
		util.waitForElementPresent(rhAccessCaseSearchFieldLocator);
		util.sendKeysTo(rhAccessCaseSearchFieldLocator, text);
		driver.findElement(HawkularRHASupportCaseConstants.rhAccessSearchButton).click();
	}

	public void verifyOpenCaseSearchResults() {
		HawkularUtils util = new HawkularUtils(driver);
		util.waitForElementPresent(searchResultLocator);

	}

	public void searchOpenandClosedTickets(String text) {
		HawkularUtils util = new HawkularUtils(driver);
		util.waitForElementPresent(rhAccessStatusDropdownLocator);
		driver.findElement(HawkularRHASupportCaseConstants.rhAccessStatusDropdownLocator).click();
		util.waitForElementPresent(selectStatusOpenandClosed);
		driver.findElement(HawkularRHASupportCaseConstants.selectStatusOpenandClosed).click();
		driver.findElement(HawkularRHASupportCaseConstants.rhAccessCaseSearchFieldLocator).clear();
		util.sendKeysTo(rhAccessCaseSearchFieldLocator, text);
		driver.findElement(HawkularRHASupportCaseConstants.rhAccessSearchButton).click();
	}

	public void verifyOpenAndClosedSearchResult() {
		HawkularUtils util = new HawkularUtils(driver);
		driver.findElement(HawkularRHASupportCaseConstants.verifyTicket);

	}

	public void verifyCaseDetails() {
		HawkularUtils util = new HawkularUtils(driver);
		util.waitForElementPresent(supportCaseIDLocator);
		driver.findElement(HawkularRHASupportCaseConstants.supportCaseIDLocator).click();
		util.waitForElementPresent(supportCaseDetailsLocator);
	}


	public void switchFrameFocus() {
		driver.switchTo().frame("myCasesWindow");		
	}	


	public void switchFrameFocus(boolean defaultFrame) {
		if (defaultFrame == false) {
			switchFrameFocus();
		} else {
			driver.switchTo().defaultContent();
		}
	}


}
