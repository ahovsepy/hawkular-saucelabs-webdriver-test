package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */
public class hawkularAlertSeverityFilterConstants {
	
	 public static final By alertCenter = By.xpath("html/body/nav/div[2]/div[2]/hawkular-topbar/ul/li[1]/a");
	 public static final By alertDefinitions= By.xpath("html/body/div[1]/div/div/div/hawkular-subtab/div/div/div[3]/div/ul/li[2]/a");
	 public static final By clickSearchBox= By.xpath(".//*[@id='DataTables_Table_0_filter']/label/input");
	 public static final By verifySeverity= By.xpath("html/body/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[1]/td[5]");
	 public static final By verifyDescription= By.xpath("html/body/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]");


}
