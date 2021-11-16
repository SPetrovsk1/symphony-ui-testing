package Utils;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseSuite {

    @BeforeSuite
    public void beforeSuite(ITestContext iTestContext){
        String suiteName = iTestContext.getSuite().getName();
        Logger.info("BeforeSuite has started for:" + suiteName);
    }

    @AfterSuite
    public void afterSuite(ITestContext iTestContext){
        String suiteName = iTestContext.getSuite().getName();
        Logger.info("AfterSuite has started for:" + suiteName);
    }
}
