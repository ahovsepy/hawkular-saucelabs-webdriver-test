package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qe.hawkular.element.*;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularAppServerDeploymentsPage {
    public final WebDriver driver;

    public HawkularAppServerDeploymentsPage(WebDriver driver) {

        this.driver = driver;
    }
    
    By disableSingleDeploymentLocator = HawkularAppServerDeploymentsConstants.disableSingleDeploymentLocator;
    By enableSingleDeploymentLocator = HawkularAppServerDeploymentsConstants.enableSingleDeploymentLocator;
    By actionSingleDeploymentLocator = HawkularAppServerDeploymentsConstants.actionSingleDeploymentLocator;
    By disabledSingleDeploymentLocator = HawkularAppServerDeploymentsConstants.disabledSingleDeploymentLocator;
    /*By usernameLocator = HawkularLoginPageConstants.usernameLocator;
    By passwordLocator = HawkularLoginPageConstants.passwordLocator;
    By loginButtonLocator = HawkularLoginPageConstants.loginButtonLocator;
    By registrationLink = HawkularLoginPageConstants.registrationLink;
    By backToLoginLink = HawkularRegistrationPageConstants.backToLoginLink;
    By invalidUsernamePasswordError = HawkularLoginPageConstants.invalidUsernamePasswordError;
    By errorAlert = HawkularManagementConsolePageConstants.errorAlert;
*/
   /* public HawkularAppServerDeploymentsPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);

        return this;
    }

    public void navigateToRegistration() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(registrationLink);
    }
  

    public HawkularAppServerDeploymentsPage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HawkularAppServerDeploymentsPage(driver);
    }*/

    public HawkularAppServerDeploymentsPage disableSingleDeployment() {
        driver.findElement(actionSingleDeploymentLocator).click();
        //driver.findElement(disableSingleDeploymentLocator).submit();
        driver.findElement(disableSingleDeploymentLocator).click();
        WebDriverWait wait = new WebDriverWait(driver, 180);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(disabledSingleDeploymentLocator));
     // driver.quit();
        driver.findElement(enableSingleDeploymentLocator).click();

        return new HawkularAppServerDeploymentsPage(driver);
    }

}


