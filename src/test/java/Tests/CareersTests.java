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

    private static final int EXPECTED_NUMBER_OF_OPEN_POSITIONS = 60;

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
        Assert.assertEquals(careersPage.getOpenPositionList().size(), EXPECTED_NUMBER_OF_OPEN_POSITIONS, "Number of open positions not ok!");
    }
}
