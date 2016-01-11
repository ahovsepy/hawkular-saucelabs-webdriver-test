package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qe.hawkular.element.HawkularDatasourcesPageConstants;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.Assert;
import org.testng.Reporter;

public class HawkularDatasourcesPage {

    public final WebDriver driver;

    public HawkularDatasourcesPage(WebDriver driver) {
        this.driver = driver;
    }

    By addDriver = HawkularDatasourcesPageConstants.addDriver;
    By loadDriverFile = HawkularDatasourcesPageConstants.loadDriverFile;
    String driverFilePath = HawkularDatasourcesPageConstants.driverFilePath;
    By driverFilePathNextButton = HawkularDatasourcesPageConstants.driverFilePathNextButton;

    By driverNameSelect = HawkularDatasourcesPageConstants.driverNameSelect;
    String driverName = HawkularDatasourcesPageConstants.driverName;
    By driverModuleNameSelect = HawkularDatasourcesPageConstants.driverModuleNameSelect;
    String driverModuleName = HawkularDatasourcesPageConstants.driverModuleName;
    By driverClassSelect = HawkularDatasourcesPageConstants.driverClassSelect;
    String driverClass = HawkularDatasourcesPageConstants.driverClass;
    By driverParamsNextButton = HawkularDatasourcesPageConstants.driverParamsNextButton;

    By addButton = HawkularDatasourcesPageConstants.addButton;
    
    By exportJDR = HawkularDatasourcesPageConstants.exportJDR;
    
    By addDatasource = HawkularDatasourcesPageConstants.addDatasource;
    By nonxadatasource = HawkularDatasourcesPageConstants.nonxadatasource;
    By datasourceTypeNextButton = HawkularDatasourcesPageConstants.datasourceTypeNextButton;
    By datasourceNameSelect = HawkularDatasourcesPageConstants.datasourceNameSelect;
    String datasourceName = HawkularDatasourcesPageConstants.datasourceName;
    String overviewDatasourceName = HawkularDatasourcesPageConstants.overviewDatasourceName;
    By datasourceAttributeNextButton = HawkularDatasourcesPageConstants.datasourceAttributeNextButton;
    
    By datasourceClassSelect = HawkularDatasourcesPageConstants.datasourceClassSelect;
    By datasourceConnURLSelect = HawkularDatasourcesPageConstants.datasourceConnURLSelect;
    String datasourceClass = HawkularDatasourcesPageConstants.datasourceClass;
    String datasourceConnURL = HawkularDatasourcesPageConstants.datasourceConnURL;
    By datasourceDriverNextButton = HawkularDatasourcesPageConstants.datasourceDriverNextButton;
    By datasourceXAPropertiesNextButton = HawkularDatasourcesPageConstants.datasourceXAPropertiesNextButton;

    By datasourceUsernameSelect = HawkularDatasourcesPageConstants.datasourceUsernameSelect;
    By datasourcepwdSelect = HawkularDatasourcesPageConstants.datasourcepwdSelect;
    
    String datasourceUsernamepwd = HawkularDatasourcesPageConstants.datasourceUsernamepwd;
    By datasourceConnSettingsNextButton = HawkularDatasourcesPageConstants.datasourceConnSettingsNextButton;
    By datasourceAddButton = HawkularDatasourcesPageConstants.datasourceAddButton;
    By createDatasourceSuccessMsg = HawkularDatasourcesPageConstants.createDatasourceSuccessMsg;
    By exitButton = HawkularDatasourcesPageConstants.exitButton;

    By datasourceHeading = HawkularDatasourcesPageConstants.datasourceHeading;
    By actionsDropdownLocator = HawkularDatasourcesPageConstants.actionsDropdownLocator;
    By deleteAction = HawkularDatasourcesPageConstants.deleteAction;
    By confirmDeleteLocator = HawkularDatasourcesPageConstants.confirmDeleteLocator;
    By deleteDatasourceSuccessMsg = HawkularDatasourcesPageConstants.deleteDatasourceSuccessMsg;
    By datasourceHeadingLocator = HawkularDatasourcesPageConstants.datasourceHeadingLocator;
    
    // TODO optional: Driver Major Version , Driver Minor Version

    public void navigateAddDriverTab() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(addDriver);
        util.waitForElementPresent(loadDriverFile);
    }

    public void loadDriverFile() {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(loadDriverFile, driverFilePath);
        util.navigateTo(driverFilePathNextButton);
    }

    public void defineDriverParams() {
        HawkularUtils util = new HawkularUtils(driver);
        util.sendKeysTo(driverNameSelect, driverName);
        util.sendKeysTo(driverModuleNameSelect, driverModuleName);
        util.sendKeysTo(driverClassSelect, driverClass);
        util.navigateTo(driverParamsNextButton);
    }

    public void addDriverSubmit() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(addButton);
    }
    
    public void exportJDR() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(exportJDR);
    }
    
    public void addDatasourceType() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(addDatasource);
       util.waitForElementPresent(nonxadatasource);
        util.navigateTo(nonxadatasource);
        util.navigateTo(datasourceTypeNextButton);
        
    }
    
    public void overviewAddDatasourceType() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(nonxadatasource);
        util.navigateTo(nonxadatasource);
        util.navigateTo(datasourceTypeNextButton);
        
    }
    
    public void addDatasourceAttribute() {
    	HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(datasourceNameSelect);
        util.sendKeysTo(datasourceNameSelect, datasourceName);
//        util.waitForElementPresent(datasourceAttributeNextButton);
        util.navigateTo(datasourceAttributeNextButton);
    }
    
    public void overviewAddDatasourceAttribute() {
    	HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(datasourceNameSelect);
        util.sendKeysTo(datasourceNameSelect, overviewDatasourceName);
        util.navigateTo(datasourceAttributeNextButton);
    }

    public void addDatasourceDriverParams() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(datasourceClassSelect);
        util.sendKeysTo(datasourceClassSelect, datasourceClass);
        util.sendKeysTo(datasourceConnURLSelect, datasourceConnURL);
        util.navigateTo(datasourceDriverNextButton);
//        util.navigateTo(datasourceXAPropertiesNextButton);
        
    }
    
    public void addDatasourceConnSettings() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(datasourceUsernameSelect);
        util.sendKeysTo(datasourceUsernameSelect, datasourceUsernamepwd);
        util.sendKeysTo(datasourcepwdSelect, datasourceUsernamepwd);
        util.navigateTo(datasourceConnSettingsNextButton);
        
    }

    public void datasourceAdd() {
        HawkularUtils util = new HawkularUtils(driver);
        util.navigateTo(datasourceAddButton);
    }
    
    public void addDatasourceVerifySuccess() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(createDatasourceSuccessMsg);
        Reporter.log("Datasource added successfully");
        util.navigateTo(exitButton);
        
    }
    
    public void deleteDatasource() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(datasourceHeadingLocator); 
        util.navigateTo(actionsDropdownLocator);
        util.navigateTo(deleteAction);
        util.navigateTo(confirmDeleteLocator);
    }
    
    public void verifyDeleteDatasource() {
        HawkularUtils util = new HawkularUtils(driver);
        util.waitForElementPresent(deleteDatasourceSuccessMsg);
        util.waitForElementNotPresent(datasourceHeadingLocator);        
        Reporter.log("Datasource deleted successfully");
                
    }   
    
}
