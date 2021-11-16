package Tests;

import Pages.AboutUsPage;
import Pages.CareersPage;
import Pages.HomePage;
import Utils.BaseTestClass;
import Utils.FileWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CareersTests extends BaseTestClass {

    private HomePage homePage;
    private CareersPage careersPage;

    @Override
    protected void beforeClassExtended() {

        homePage = new HomePage(driver);
        homePage = (HomePage) homePage.navigateTo(baseUrl, homePage);
    }

    @Test(priority = 1)
    public void goToCareersPage() {
        careersPage = homePage.navigateToCurrentOpenings();
        careersPage.readOpenPositions();
        FileWriter.addJobsToTextFile(careersPage.getOpenPositionList());
        Assert.assertEquals(careersPage.getOpenPositionList().size(), 60, "Number of open positions not ok!");
    }
}
