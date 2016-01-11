package org.qe.hawkular.element;

import org.openqa.selenium.By;

public class HawkularDatasourcesPageConstants {

    public static final By addDriver = By.xpath("id('hk-datasources')//button[text()='Add Driver']");
    public static final By loadDriverFile = By.id("driver-file");
    public static final String driverFilePath = "/hawkular-ui-test/src/test/resources/mysql-connector-java-5.1.36-bin.jar";// TODO URL or Path?
    public static final By driverFilePathNextButton = By.xpath("//div[@class='modal-footer']"
            + "//button[@ng-disabled='addJdbcDriverForm.$invalid' and @class='btn btn-primary' and "
            + "contains(text(),'Next >') and not(@disabled)]");

    public static final By driverNameSelect = By.id("dn");
    public static final String driverName = "mysql";
    public static final By driverModuleNameSelect = By.id("dmn");
    public static final String driverModuleName = "com.mysql";
    public static final By driverClassSelect = By.id("dc");
    public static final String driverClass = "com.mysql.jdbc.Driver";
    public static final By driverParamsNextButton = By
            .xpath("//div[@class='modal-footer']//button["
                    + "@ng-disabled='!dac.driverData.driverName || !dac.driverData.moduleName || !dac.driverData.driverClass' "
                    + "and @class='btn btn-primary' and contains(text(),'Next >') and not(@disabled)]");

    public static final By addButton = By
            .xpath("//div[@class='modal-footer']//button[contains(text(),'Add') ]");

    public static final By exportJDR = By.xpath("//button[contains(text(),'Export JDR')]");
    
    public static final By addDatasource = By.xpath("id('hk-datasources')//button[text()='Add Datasource']");
    public static final By nonxadatasource = By
                    .xpath("//input[@name='datasource-type' and @value='false']");        
    public static final By datasourceTypeNextButton = By
                    .xpath("//button[@ng-disabled='addDatasourceForm.$invalid' and contains(text(),'Next >')]");
    public static final By datasourceNameSelect = By.id("name");
    public static final String datasourceName = "TestDS";
    public static final String overviewDatasourceName = "TestDataSource";
    public static final By datasourceHeadingLocator = By.xpath("//span[contains(text(),'TestDS')]");
    public static final By datasourceAttributeNextButton = By
            .xpath("//button[@ng-disabled='!dac.dsData.jndiName' and contains(text(),'Next >')]");    
    public static final By datasourceClassSelect = By.id("dsClass");
    public static final By datasourceConnURLSelect = By.id("connUrl");
    public static final String datasourceClass = "org.h2.jdbcx.JdbcDataSource";
    public static final String datasourceConnURL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
//    public static final By datasourceDriverNextButton = By
//            .xpath("/html/body/div[10]/div/div/div[2]/div/section[3]/div[2]/button[3]");
    public static final By datasourceDriverNextButton = By
    .xpath("//div[@class='modal-footer']//button[contains(@ng-disabled,'!dac.dsData.connectionUrl') ]");
    public static final By datasourceXAPropertiesNextButton = By
            .xpath("//button[@ng-click='dac.exitStepXAProperties()' and contains(text(),'Next >')]");
    public static final By datasourceUsernameSelect = By.id("un");
    public static final By datasourcepwdSelect = By.id("pw");
    public static final String datasourceUsernamepwd = "sa";
    public static final By datasourceConnSettingsNextButton = By
            .xpath("//button[@ng-click='dac.exitStepDefineParameters()' and contains(text(),'Next >')]");
    public static final By datasourceAddButton = By
            .xpath("//div[@class='modal-footer']//button[contains(text(),'Add') ]");
    public static final By createDatasourceSuccessMsg = By.xpath("//div[contains(.,'successfully created')]");
    public static final By exitButton = By
            .xpath("//div[@class='modal-footer']//button[contains(text(),'Exit') ]");
    
    public static final By datasourceHeading = By
            .xpath("//div[@class='panel-heading']//span[contains(text(),'Datasource [TestDS]') ]");
    public static final By actionsDropdownLocator =  By.xpath("//*[text() = 'TestDS']/../..//button");
    public static final By deleteAction = By.linkText("Delete");
    public static final By confirmDeleteLocator = By.xpath("//button[text()='Delete']");
    public static final By deleteDatasourceSuccessMsg = By.xpath("//*[contains(text(),'Execution Ops request delivery: The request has been forwarded to feed')]");

}