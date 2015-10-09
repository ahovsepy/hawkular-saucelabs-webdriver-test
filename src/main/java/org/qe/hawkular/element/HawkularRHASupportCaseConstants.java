package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularRHASupportCaseConstants {


	public static final By rhAccessDropdownLocator = By.xpath("//li[@class='dropdown']//a[contains(text(),'Red Hat Access')]");
	public static final By rhAccessSupportLocator = By.linkText("Support");
	public static final By rhSupportmyCasesLocator = By.xpath("//a[@href='/hawkular-ui/access/myCases']");
	public static final By rhAccessStatusDropdownLocator = By.xpath("//a[@class='chosen-single']//span[contains(text(),'Open')]");
	public static final By selectStatusOpenandClosed = By.xpath("//li[(@data-option-array-index='0') and contains(text(),'Open and Closed')]");
	public static final By rhAccessSearchButton = By.id("rha-searchform-searchbutton");
	public static final By searchResultLocator = By.xpath("//*[text()='Waiting on Red Hat']");
	public static final By rhAccessCaseSearchFieldLocator = By.id("rha-searchform-searchbox");
	public static final By verifyTicket = By.xpath("//*[text()='Test Ignore']"); 
	public static final By supportCaseIDLocator = By.cssSelector("tr.ng-scope td a.ng-binding");
	public static final By supportCaseDetailsLocator = By.xpath("//*[contains(text(), 'Case')]");

}
