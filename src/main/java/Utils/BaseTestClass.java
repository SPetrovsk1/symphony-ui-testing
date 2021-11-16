package Utils;

import Enums.DriverTypeEnum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTestClass extends BaseTest {

    protected WebDriver driver;
    protected String baseUrl;
    protected SoftAssert softAssert;

    @BeforeClass
    protected void beforeClass() {
        baseUrl = PropertiesReader.readFromProperties(ConfigurationConstants.TESTING_PROPERTIES_PATH, ConfigurationConstants.BASE_URL_PROPERTY);
        String driverType = PropertiesReader.readFromProperties(ConfigurationConstants.TESTING_PROPERTIES_PATH, ConfigurationConstants.DRIVER_TYPE_PROPERTY);
        driver = DriverFactory.createDriverForSpecificBrowser(DriverTypeEnum.parse(driverType));
        beforeClassExtended();
    }


    protected void beforeClassExtended() {
        //left empty in order to be overwritten in child classes
    }

    @BeforeMethod
    protected void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @AfterMethod
    protected void afterMethod() {
        softAssert.assertAll();
    }

    protected void afterClassExtended() {
        //left empty in order to be overwritten in child classes
    }

    @AfterClass(alwaysRun = true)
    protected void afterClass() {
        afterClassExtended();
        driver.quit();
    }
}
