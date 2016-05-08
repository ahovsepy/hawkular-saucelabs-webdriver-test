package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularAppServerPage;
import org.qe.hawkular.page.HawkularConsoleAddUrlPage;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularTokenPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HawkularTokenTest extends HawkularSeleniumLocalWebDriver {
		WebDriver driver = null;

	    public WebDriver hawkularLogin() throws Exception {
	        driver = createLocalDriver();

	        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
	        System.out.println(driver.getTitle());

	        HawkularLoginPage loginPage = new HawkularLoginPage(driver);

	        loginPage = new HawkularLoginPage(driver);
	        loginPage.loginAs(HawkularRegistrationPageConstants.username2,
	                HawkularRegistrationPageConstants.password2);       

	        return driver;
	    }

	    
	    @AfterMethod
		public void closeSession() {
			driver.quit();
		}
	    
	    @Test
	    public void hawkularCreateTokenTest() throws Exception {
	         driver = hawkularLogin();
	        
	        HawkularTokenPage token = new HawkularTokenPage(driver);
	        token.createToken();       
	        
	    }

	    @Test
	    public void hawkularDeleteTokenTest() throws Exception {
	        WebDriver driver = hawkularLogin();
	        
	        HawkularTokenPage token = new HawkularTokenPage(driver);
	        token.deleteToken();       
	        
	    }

}


