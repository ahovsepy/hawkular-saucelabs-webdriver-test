package org.qe.hawkular.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qe.hawkular.element.HawkularRHAPageConstants;
import org.testng.Assert;

public class HawkularRedHatAccess {

	WebDriver driver;

	private String username;
	private String password;

	private String originalURL;

	By usernameLocator = HawkularRHAPageConstants.usernameLocator;
	By passwordLocator = HawkularRHAPageConstants.passwordLocator;
	By signinLocator = HawkularRHAPageConstants.signinLocator;
	By rhaiframeLocator = HawkularRHAPageConstants.rhaiframeLocator;
	By cancelLocator = HawkularRHAPageConstants.cancelLocator;

	public HawkularRedHatAccess(WebDriver driver) {
		this.driver = driver;
		username = System.getProperty("rhausername");
		password = System.getProperty("rhapassword");
		if (username == null || password == null) {
			Assert.assertTrue(false,
					"Missing credentials for Red Hat Access, please check READEME.md");
		}
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}
	
	public void loginHere() {
		HawkularUtils util = new HawkularUtils(driver);
		util.sendKeysTo(usernameLocator, username);
		util.sendKeysTo(passwordLocator, password);
		util.waitForElementPresent(signinLocator);
	}

	public void switchFrameFocus() {
		originalURL = driver.getCurrentUrl();
		WebElement frame = driver.findElement(rhaiframeLocator);
		driver.switchTo().frame(frame);
	}
	
	public void switchFrameFocus(boolean defaultFrame) {
		if (defaultFrame == false) {
			switchFrameFocus();
		} else {
			driver.switchTo().defaultContent();
			originalURL = null;
		}
	}

	public void cancleLogin() {
		HawkularUtils util = new HawkularUtils(driver);
		util.navigateTo(cancelLocator);
	}

}