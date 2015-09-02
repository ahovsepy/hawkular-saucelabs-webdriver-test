package org.qe.hawkular.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qe.hawkular.element.HawkularRHAPageConstants;

public class HawkularRedHatAccess {

	WebDriver driver;

	private String username;
	private String password;

	private String originalURL;

	
	By usernameLocator = HawkularRHAPageConstants.usernameLocator;
	By passwordLocator = HawkularRHAPageConstants.passwordLocator;
	By signinLocator = HawkularRHAPageConstants.signinLocator;
	By rhaiframeLocator = HawkularRHAPageConstants.rhaiframeLocator;
	
	public HawkularRedHatAccess(WebDriver driver) {
		this.driver = driver;
		username = System.getProperty("rhausername");
		password = System.getProperty("rhapassword");
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
		originalURL = driver.getCurrentUrl();
		WebElement frame=driver.findElement(rhaiframeLocator);
		driver.switchTo().frame(frame);
		HawkularUtils util = new HawkularUtils(driver);
		util.waitForElementPresent(signinLocator);
		util.waitForElementPresent(usernameLocator);
		util.waitForElementPresent(passwordLocator);
		driver.findElement(usernameLocator).sendKeys(username);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(signinLocator).click();
	}
	
}