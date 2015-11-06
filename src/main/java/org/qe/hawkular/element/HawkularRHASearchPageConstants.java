package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularRHASearchPageConstants {
	
    public static final By rhSearchLocator = By.id("rhSearchStr");
    public static final By rhSearchButtonLocator = By.id("rh-search").xpath("//*/button");
    public static final String searchWindowLocator = "searchWindowLocator";
    public static final By solutionLocator = By.xpath("//div[@id='solutions']/a[1]");
 
}