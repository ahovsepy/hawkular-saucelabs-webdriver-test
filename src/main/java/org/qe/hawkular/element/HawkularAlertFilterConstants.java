package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */
public class HawkularAlertFilterConstants {
	
	 public static final By alertCenter = By.linkText("Alert Center");
	 public static final By alertDefinitions = By.linkText("Definitions");
	 public static final By clickSearchBox= By.xpath(".//*[@id='DataTables_Table_0_filter']/label/input");
	 public static final By verifySeverity= By.xpath("//*[text()='High']");
	 public static final By verifyDescription=By.xpath("//*[text()='JVM Heap Used']");

}
