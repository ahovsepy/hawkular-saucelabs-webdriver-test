package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularAddDeploymentConstants;
import org.qe.hawkular.util.HawkularUtils;

public class HawkularAddDeploymentPage {

	public final WebDriver driver;

    public HawkularAddDeploymentPage(WebDriver driver) {
        this.driver = driver;
    }
	
	 By addDeploymentTab = HawkularAddDeploymentConstants.addDeploymentTab;
	 By uploadFileTab = HawkularAddDeploymentConstants.uploadFileTab;
	 String applicationFilePath = HawkularAddDeploymentConstants.applicationFilePath;
	 String overviewApplicationFilePath = HawkularAddDeploymentConstants.overviewApplicationFilePath;
	 By applicationFilePathNextButton = HawkularAddDeploymentConstants.applicationFilePathNextButton;
	 By addDeploymentNextButton = HawkularAddDeploymentConstants.addDeploymentNextButton;
	 By verifyDeploymentSuccess = HawkularAddDeploymentConstants.verifyDeploymentSuccess;
	 
	 
	 public void addDeploymentTab() {
	        HawkularUtils util = new HawkularUtils(driver);
	        util.navigateTo(addDeploymentTab);
	        util.waitForElementPresent(uploadFileTab);
	    }
	 public void uploadApplicationFile() {
	        HawkularUtils util = new HawkularUtils(driver);
	        util.sendKeysTo(uploadFileTab, applicationFilePath);
	        util.navigateTo(applicationFilePathNextButton);
	 }
	 
	 public void overviewUploadApplicationFile() {
	        HawkularUtils util = new HawkularUtils(driver);
	        util.waitForElementPresent(uploadFileTab);
	        util.sendKeysTo(uploadFileTab, overviewApplicationFilePath);
	        util.navigateTo(applicationFilePathNextButton);
	 }
	 
	  public void deployApplication() {
	        HawkularUtils util = new HawkularUtils(driver);
	        util.waitForElementPresent(addDeploymentNextButton);
	        util.navigateTo(addDeploymentNextButton);
	    }
	  public void verfiySuccess() {
			HawkularUtils utils = new HawkularUtils(driver);
			utils.waitForElementPresent(verifyDeploymentSuccess);
	  }
}
