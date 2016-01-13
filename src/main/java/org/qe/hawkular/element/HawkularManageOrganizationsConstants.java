package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author vprusa
 */
public class HawkularManageOrganizationsConstants {

    /* Navigate */
    public static final By rhAccessDropdownLocator = By
            .xpath("//span[@class='pficon pficon-user']/../../a");
    public static final By rhAccessManageOrgOptionLocator = By
            .id("organizationsOption");

    /* Create organization */
    public static final By createOrgButtonLocator = By
            .xpath("//div[@class='blank-slate-pf-main-action']/button");
    public static final By organizationNameLocator = By
            .id("name");
    public static final String organizationName = "orgname.org";
    public static final By listOrganizationLocator = By.linkText("orgname.org");
    public static final By modalCreateOrgButtonLocator = By
            .xpath("//div[@class='modal-dialog']//button[text()='Create']");
    public static final By createOrgVerifyLocator = By
            .xpath("//div[contains(text(),'Organization successfully created.')]");

    /* Remove organization */
    public static final By removeOrgButtonLocator = By
            .xpath("//div[@class='hk-organizations row']//tr[1]//td[2]/button/..//i[contains(@class,'fa-trash-o')]");
    public static final By removeOrgButtonConfirmLocator = By
            .xpath("//div[@class='modal-dialog']//button[text()='Delete']");
    public static final By removeOrgVerifyLocator = By
            .xpath("//div[contains(text(),'Organization successfully deleted.')]");
    
    /* Invite User to organization */
    public static final By userTab = By.xpath("html/body/nav/div[2]/div[2]/ul/li[2]/a");
	public static final By clickManageOrganization = By.id("organizationsOption");
//	public static final By selectOrganization= By.xpath("html/body/div[1]/div/div/div/div[1]/div[4]/table/tbody/tr[1]/td[1]/a");
	public static final By selectOrganization= By.linkText(""+organizationName);
//	public static final By invitePeopleButton= By.xpath("html/body/div[1]/div/div/div/div[1]/div[3]/button");
	public static final By invitePeopleButton= By.xpath("//button[contains(text(),'Invite People')]");
	public static final By inviteViaEmail= By.xpath(".//*[@id='emails']");
	public static final By inviteTab = By.xpath(".//*[@id='inviteToOrganizationFormBtn']");
	public static final By successMassage = By.xpath(".//*[@id='toast-container']/div[1]/div/div");
	public static final By AllOrganizationsLinkLocator = By.linkText("« All organizations");
    
	public static final By createOrgButtonLocatorNoOrgCreated = By.xpath("//button[contains(text(),'Create Organization')]");  // User has yet to creat
	public static final By craateOrgButtonLocatorOrgsCreated = By.xpath("//div[@class='text-right']/button"); // User already has created one or more O
	public static final By navigateToNewOrg = By.xpath("/html/body/nav/div[2]/div[2]/ul/li/ul/li[2]/a");
	public static final By NavigateToJDoe = By.xpath("/html/body/nav/div[2]/div[2]/ul/li/ul/li[3]/a");
}