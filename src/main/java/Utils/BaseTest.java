package Utils;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest extends BaseSuite {

    @BeforeSuite
    public void beforeTest(ITestContext iTestContext) {
        Logger.info("BeforeTest has started!");
    }

    @AfterSuite
    public void afterTest(ITestContext iTestContext) {
        Logger.info("AfterTest has started!");
    }

}
