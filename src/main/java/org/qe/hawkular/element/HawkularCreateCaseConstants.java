package org.qe.hawkular.element;



import org.openqa.selenium.By;

public class HawkularCreateCaseConstants {


	public static final By clickRedHatAccess =  By.linkText("Red Hat Access");
	public static final By clickRedHatAccessSupport =  By.linkText("Support");
	public static final By clickRedHatAccessSupportOpenCase =  By.linkText("Open Case");
	public static final By rhaiframeLocatorLogin = By.xpath("//iframe[@src='/support.html#/case/new']");
	public static final By enterRedHatAccessAccount =  By.xpath("//button[text()='My Account']");
	public static final By clickRedHatProduct = By.id("rha-product-select");
	public static final By selectRedHatProduct = By.xpath("//select[@id='rha-product-select']/option[text()='Red Hat JBoss Operations Network']");
	public static final By selectRedHatProductVersion =  By.xpath("//select[@id='rha-product-version-select']/option[text()='3.3.3']");
	public static final By typeSummary = By.id("rha-case-summary");
	public static final By writeDescription = By.id("rha-case-description");
	public static final By clickNext =  By.xpath("//button[text()='Next']");
	public static final By clickSupportLevel =  By.xpath("//select[@id='rha-entitlement-select']");
	public static final By selectSupportLevel =  By.xpath("//select[@id='rha-entitlement-select']/option[text()='PROFESSIONAL']");
	public static final By clickSeverity =  By.xpath("//select[@id='rha-severity']");
	public static final By selectSeverity =  By.xpath("//select[@id='rha-severity']/option[text()='1 (Urgent)']");
	public static final By clickSubmit =  By.xpath("//button[text()='Submit']");
	public static final By jdrReportLink =  By.xpath("//a[contains(text(), 'jdr_')]");
	public static final By deleteJdrReportLink =  By.linkText("Delete");
	public static final By deleteJDRMsg =  By.xpath("//*[contains(text(), 'Successfully deleted attachment')]");
	public static final By createCaseSuccessMsg = By.xpath("//*[contains(text(),'Successfully created case number')]");


}
