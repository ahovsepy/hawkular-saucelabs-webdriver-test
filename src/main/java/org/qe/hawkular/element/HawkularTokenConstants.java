package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularTokenConstants {
	
	public static final By clickUser= By.xpath("//a[contains(@class,'dropdown-toggle')]");
	public static final By clickTokens= By.xpath(".//*[@id='tokensOption']");
	public static final By clickCreateToken= By.xpath("//button[contains(text(),'Create Token')]");
	public static final By clickDeleteToken= By.xpath("//button[@tooltip='Revoke']");
	public static final By clickRevoke= By.xpath("//button[contains(text(),'Revoke')]");
	

}
