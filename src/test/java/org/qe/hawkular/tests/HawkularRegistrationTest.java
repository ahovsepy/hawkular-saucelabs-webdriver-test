package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Test case for registration tests.
 *
 */

public class HawkularRegistrationTest extends HawkularSeleniumLocalWebDriver {
	WebDriver driver = null;

	@Test
	public void hawkularRegistrationBasicTest() throws Exception {
		driver = createLocalDriver();
		HawkularRegistrationPage registration = new HawkularRegistrationPage(
				driver);
		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		registration.registerUserIfDoesNotExist(HawkularRegistrationPageConstants.username, HawkularRegistrationPageConstants.password, HawkularRegistrationPageConstants.confirmPassword, HawkularRegistrationPageConstants.firstName, HawkularRegistrationPageConstants.lastName, HawkularRegistrationPageConstants.email);

	}

	@AfterMethod
	public void closeSession() {
		driver.quit();
	}
	
	@Test
	public void hawkularRegistrationMismatchPasswordsTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		_logger.info(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.navigateToRegistration();

		HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
		regPage.register(HawkularRegistrationPageConstants.generateUsername(),
				HawkularRegistrationPageConstants.wrongPassword,
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.generateEmail(),
				HawkularRegistrationPageConstants.firstName,
				HawkularRegistrationPageConstants.lastName);
		regPage.verifyMismatchPasswords();
	}


	@Test
	public void hawkularRegistrationNoPasswordsTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		_logger.info(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.navigateToRegistration();

		HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
		regPage.register(HawkularRegistrationPageConstants.generateUsername(),
				"",
				"",
				HawkularRegistrationPageConstants.generateEmail(),
				HawkularRegistrationPageConstants.firstName,
				HawkularRegistrationPageConstants.lastName);
		regPage.verifyNoPasswords();
	}

	@Test
	public void hawkularRegistrationNoEmailTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		_logger.info(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.navigateToRegistration();

		HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
		regPage.register(HawkularRegistrationPageConstants.generateUsername(),
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.password,
				"",
				HawkularRegistrationPageConstants.firstName,
				HawkularRegistrationPageConstants.lastName);
		regPage.verifyNoEmail();
	}

	@Test
	public void hawkularRegistrationNoFirstNameTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		_logger.info(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.navigateToRegistration();

		HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
		regPage.register(HawkularRegistrationPageConstants.generateUsername(),
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.email,
				"",
				HawkularRegistrationPageConstants.lastName);
		regPage.verifyNoFirstName();
	}

	@Test
	public void hawkularRegistrationNoLastNameTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		_logger.info(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.navigateToRegistration();

		HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
		regPage.register(HawkularRegistrationPageConstants.generateUsername(),
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.email,
				HawkularRegistrationPageConstants.firstName,
				"");
		regPage.verifyNoLastName();
	}

	@Test
	public void hawkularRegistrationNoUserNameTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		_logger.info(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.navigateToRegistration();

		HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
		regPage.register("",
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.password,
				HawkularRegistrationPageConstants.email,
				HawkularRegistrationPageConstants.firstName,
				HawkularRegistrationPageConstants.lastName);
		regPage.verifyNoUsername();
	}

	@Test
	public void hawkularRegistrationPasswordMinLengthTest() throws Exception {
		driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		_logger.info(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);
		loginPage.navigateToRegistration();

		HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
		regPage.register(HawkularRegistrationPageConstants.generateUsername(),
				HawkularRegistrationPageConstants.wrongPassword,
				HawkularRegistrationPageConstants.wrongPassword,
				HawkularRegistrationPageConstants.email,
				HawkularRegistrationPageConstants.firstName,
				HawkularRegistrationPageConstants.lastName);
		regPage.verifyPasswordMinLength();
	}


}
