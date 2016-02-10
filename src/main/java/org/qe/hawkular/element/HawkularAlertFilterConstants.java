package org.qe.hawkular.element;

import org.openqa.selenium.By;

/**
 * @author pyadav
 */
public class HawkularAlertFilterConstants {

    public static final By alertCenter = By.linkText("Alert Center");
    public static final By alertDefinitions = By.linkText("Definitions");
    public static final By clickSearchBox = By
            .xpath(".//*[@id='DataTables_Table_0_filter']/label/input");
    public static final By verifySeverity = By.xpath("//*[text()='Medium']");
    public static final By verifyDescription = By
            .xpath("//*[contains(text(),'JVM Heap Used')]");
    public static final By viewDetailsLink = By
            .xpath("//i[@tooltip='View Details']");
    public static final By alertTabLink = By.linkText("Alerts");
    public static final By lastJvmHeapUsedAlertLocator = By
            .xpath("//*[contains(text(),'JVM Heap Used for')]");
    public static final By viewDetailsLastJvmAlertLink = By
            .xpath("//*[contains(text(),'JVM Heap Used for')]/..//a/i");
    public static final By alertDetailPageLocator = By
            .xpath("//*[contains(text(),'Alert Details')]");
    public static final By acknowledgeButton = By
            .xpath("//button[contains(text(),'Acknowledged')]");
    public static final By saveButton = By
            .xpath("//button[contains(text(),'Save')]");
    public static final By acknowledgeComment = By
            .xpath("//*[contains(text(),'Manually acknowledged')]");
    public static final By allAlertsLink = By.linkText("« All Alerts");
    public static final By acknowledgeStatus = By
            .xpath("//*[contains(text(),'Acknowledged')]");
    public static final By resolveButton = By
            .xpath("//button[contains(text(),'Resolved')]");
    public static final By resolveComment = By
            .xpath("//*[contains(text(),'Manually resolved')]");
    // public static final By
    // resolvedAlertCheckBox=By.xpath("//*[contains(text(),'Display Resolved Alerts')]");
    // To-Do Generalise xpath for resolvedAlertCheckBox element.
    public static final By resolvedAlertCheckBox = By
            .xpath("/html/body/div/div/div/div/div/div[2]/div[2]/div[2]/div[2]/div/label/input");
    public static final By resolveStatus = By
            .xpath("//*[contains(text(),'Resolved')]");
    public static final By nextLink = By
            .xpath("//span[@class='i fa fa-angle-right']");
    public static final By failedAlertDescription = By
            .xpath("//*[contains(text(),'Deployment failure for')]");
    public static final By failedDeploymentAlertDetailsLocator = By
            .xpath("//*[contains(text(),'Deployment Failure')]");

}
