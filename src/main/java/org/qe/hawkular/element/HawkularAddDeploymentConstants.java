package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularAddDeploymentConstants {
	
	public static final By addDeploymentTab = By.xpath("//*[@id='hk-deployments']/div[5]/div[1]/div/button");
	
	//public static final By addDeploymentTab = By.xpath("id('hk-deployments')//button[text()='Add Deployment']");
	
		public static final By uploadFileTab =  By.name("deployFile");
	public static final String applicationFilePath = "/hawkular-ui-test/src/test/resources/ClusterWebApp.war";
	public static final By applicationFilePathNextButton = By.xpath("//div[@class='modal-footer ng-scope']"
            + "//button[@ng-disabled='deployFileForm.$invalid' and @class='btn btn-primary' and "
            + "contains(text(),'Next >') and not(@disabled)]");
	 
	public static final By addDeploymentNextButton = By.xpath("//div[@class='modal-footer ng-scope']//button["
            + "@ng-disabled='dac.deploymentData.editDeploymentFiles' "
            + "and @class='btn btn-primary' and contains(text(),'Next >') and not(@disabled)]");
	
	
	 public static final By verifyDeploymentSuccess = By.xpath("//div[2]/strong");

}
