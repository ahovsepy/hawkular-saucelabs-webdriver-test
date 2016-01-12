package org.qe.hawkular.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularManageOrganizationsConstants;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author vprusa
 */
public class HawkularManageOrganizationsPage {

    public final WebDriver driver;

    public HawkularManageOrganizationsPage(WebDriver driver) {
        this.driver = driver;
    }

    By rhAccessDropdownLocator = HawkularManageOrganizationsConstants.rhAccessDropdownLocator;
    By rhAccessManageOrgOptionLocator = HawkularManageOrganizationsConstants.rhAccessManageOrgOptionLocator;

    By createOrgButtonLocator = HawkularManageOrganizationsConstants.createOrgButtonLocator;
    By organizationNameLocator = HawkularManageOrganizationsConstants.organizationNameLocator;
    String organizationName = HawkularManageOrganizationsConstants.organizationName;
    By modalCreateOrgButtonLocator = HawkularManageOrganizationsConstants.modalCreateOrgButtonLocator;
    By createOrgVerifyLocator = HawkularManageOrganizationsConstants.createOrgVerifyLocator;

    By removeOrgButtonLocator = HawkularManageOrganizationsConstants.removeOrgButtonLocator;
    By removeOrgButtonConfirmLocator = HawkularManageOrganizationsConstants.removeOrgButtonConfirmLocator;
    By removeOrgVerifyLocator = HawkularManageOrganizationsConstants.removeOrgVerifyLocator;
    By listOrganizationLocator = HawkularManageOrganizationsConstants.listOrganizationLocator;
    By userTab = HawkularManageOrganizationsConstants.userTab;
    By clickManageOrganization = HawkularManageOrganizationsConstants.clickManageOrganization;
    By selectOrganization= HawkularManageOrganizationsConstants.selectOrganization;
    By invitePeopleButton= HawkularManageOrganizationsConstants.invitePeopleButton;
    By inviteViaEmail= HawkularManageOrganizationsConstants.inviteViaEmail;
    By inviteTab = HawkularManageOrganizationsConstants.inviteTab;
    By successMassage= HawkularManageOrganizationsConstants.successMassage;
    By AllOrganizationsLinkLocator= HawkularManageOrganizationsConstants.AllOrganizationsLinkLocator;

    public void toManageOrganizationsTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(rhAccessDropdownLocator);
        util.navigateTo(rhAccessManageOrgOptionLocator);
    }

    public void navigateToNewOrg() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(rhAccessDropdownLocator);
        driver.findElement(HawkularManageOrganizationsConstants.navigateToNewOrg).click();
    }
    	 
    public void navigateToJDoeUser() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(rhAccessDropdownLocator);
        driver.findElement(HawkularManageOrganizationsConstants.NavigateToJDoe).click();
    }
    	
    public void createOrganization() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(createOrgButtonLocator);
        util.sendKeysTo(organizationNameLocator, organizationName);
        util.navigateTo(modalCreateOrgButtonLocator);
        util.waitForElementPresent(createOrgVerifyLocator);
    }

    public void _createOrganization() throws InterruptedException, IOException {
        HawkularUtils util = new HawkularUtils(driver);
    	
    	// Until one action will work for both "Create Organization" button elements:
    	if (util.isTextOnPage("No organizations created")) {
    	    driver.findElement(HawkularManageOrganizationsConstants.createOrgButtonLocatorNoOrgCreated).click();
    	} else {
    	    driver.findElement(HawkularManageOrganizationsConstants.craateOrgButtonLocatorOrgsCreated).click();
    	}
    	
    	util.sendKeysTo(organizationNameLocator, organizationName);
    	util.navigateTo(modalCreateOrgButtonLocator);
    	util.whatForTextOnPage(organizationName, 5);
    }
    
    public void removeOrganization(int lineNumber) {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(removeOrgButtonLocator);
        util.navigateTo(removeOrgButtonConfirmLocator);
        util.waitForElementPresent(removeOrgVerifyLocator);
    }
    
    public void listOrganization() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(selectOrganization);
        
    }
    
    public void invitePeople(){    	
    	HawkularUtils util = new HawkularUtils(driver);
    	util.navigateTo(selectOrganization);
    	util.waitForElementPresent(invitePeopleButton);
    	util.navigateTo(invitePeopleButton);
    }

    public void enterEmail(String email) {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(inviteViaEmail,email);
        util.navigateTo(inviteTab);       

	}    
    
    public void verfiySuccess() {
		HawkularUtils utils = new HawkularUtils(driver);
		utils.waitForElementPresent(successMassage);
		
	}
    
    public void navigateToAllOrganizations() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(AllOrganizationsLinkLocator);       

	}  

}