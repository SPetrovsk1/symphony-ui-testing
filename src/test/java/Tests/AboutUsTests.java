package Tests;

import Pages.AboutUsPage;
import Pages.HomePage;
import Utils.BaseTestClass;
import org.testng.annotations.Test;

public class AboutUsTests extends BaseTestClass {

    private HomePage homePage;
    private AboutUsPage aboutUsPage;

    @Override
    protected void beforeClassExtended() {
        homePage = new HomePage(driver);
        homePage = (HomePage) homePage.navigateTo(baseUrl, homePage);
    }

    @Test(priority = 1)
    public void goToAboutUsPage() {
        aboutUsPage = homePage.navigateToAboutUsPage();
        aboutUsPage.readMetaData();
        aboutUsPage.assertMetaDataValues(softAssert, aboutUsPage.getMetaData());
        softAssert.assertAll();
    }
}
