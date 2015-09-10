package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularRHASearchPageConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularRHASearchPage {

	public final WebDriver driver;

	public HawkularRHASearchPage(WebDriver driver) {
		this.driver = driver;
	}

	By rhSearchLocator = HawkularRHASearchPageConstants.rhSearchLocator;
	By rhSearchButtonLocator = HawkularRHASearchPageConstants.rhSearchButtonLocator;
	String searchWindowLocator = HawkularRHASearchPageConstants.searchWindowLocator;
	By solutionLocator = HawkularRHASearchPageConstants.solutionLocator;

	public void search(String text) {
		HawkularUtils util = new HawkularUtils(driver);
		util.sendKeysTo(rhSearchLocator, text);
		util.navigateTo(rhSearchButtonLocator);
		util.navigateTo(solutionLocator);
	}

	public void switchFrameFocus() {
		driver.switchTo().frame("searchWindow");
	}	


	public void switchFrameFocus(boolean defaultFrame) {
		if (defaultFrame == false) {
			switchFrameFocus();
		} else {
			driver.switchTo().defaultContent();
		}
	}

}
