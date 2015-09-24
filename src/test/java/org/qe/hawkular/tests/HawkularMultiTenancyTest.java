package org.qe.hawkular.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

public class HawkularMultiTenancyTest extends HawkularSeleniumLocalWebDriver {

	@BeforeSuite
	public void prepareUser() throws MalformedURLException {
		WebDriver driver = createLocalDriver();
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularRegistrationPage registration = new HawkularRegistrationPage(
				driver);
		registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password, HawkularRegistrationPageConstants.confirmPassword, HawkularRegistrationPageConstants.firstName, HawkularRegistrationPageConstants.lastName, HawkularRegistrationPageConstants.email);

	}

	@BeforeSuite
	public void preparejonqeUser() throws MalformedURLException {
		WebDriver driver = createLocalDriver();
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularRegistrationPage registration = new HawkularRegistrationPage(
				driver);
		registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username2, HawkularRegistrationPageConstants.password2, HawkularRegistrationPageConstants.confirmPassword2, HawkularRegistrationPageConstants.firstName2, HawkularRegistrationPageConstants.lastName2, HawkularRegistrationPageConstants.email2);

	}


	@Test
	public void hawkularBasicMultiTenancyTest()
			throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());
		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		HawkularUtils util = new HawkularUtils(driver);
		util.assertTitle(HawkularLoginPageConstants.loginTitle);
		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.password);

		HawkularConsoleAddUrlPage addUrlPage = new HawkularConsoleAddUrlPage(
				driver);
		addUrlPage.verifyConsoleImagePresent();
		addUrlPage.addURLIfDoesNotExist(HawkularManagementConsolePageConstants.testURL);
		addUrlPage.verifyUrlExists();
		addUrlPage.navigateToURLsMenu();
		loginPage.logout();
		loginPage.loginAs(HawkularRegistrationPageConstants.username2,
				HawkularRegistrationPageConstants.password2);
		addUrlPage.verifyConsoleImagePresent();
		addUrlPage.verifyUrlDoesnotExist();
		addUrlPage.addURLIfDoesNotExist(HawkularManagementConsolePageConstants.testURL);
		addUrlPage.verifyUrlExists();
		addUrlPage.deleteURL();
		addUrlPage.verifyUrlDoesnotExist();
		loginPage.logout();
		loginPage.loginAs(HawkularRegistrationPageConstants.username,
				HawkularRegistrationPageConstants.password);
		addUrlPage.verifyConsoleImagePresent();
		addUrlPage.deleteURL();
		addUrlPage.verifyUrlDoesnotExist();
		loginPage.logout();
		driver.quit();

	}

}

