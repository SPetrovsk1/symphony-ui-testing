package Utils;

import Pages.AboutUsPage;
import Pages.CareersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private AjaxElementLocatorFactory factory;
    private Actions actions;

    @FindBy(className = "header--nav-list")
    WebElement headerLocator;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.factory = new AjaxElementLocatorFactory(driver, ConfigurationConstants.MAX_RETRY_PERIOD_AJAX_FACTORY);
        PageFactory.initElements(factory, this);
        wait = new WebDriverWait(driver, ConfigurationConstants.MAX_RETRY_FOR_LOCATING_ELEMENT);
        actions = new Actions(driver);
    }

    public abstract BasePage newInstance(WebDriver driver);

    protected void moveToElement(WebElement element) {
        actions.moveToElement(element);
        actions.perform();
    }

    public <T extends BasePage> BasePage navigateTo(String url, T type) {
        driver.get(url);
        return type.newInstance(driver);
    }

    protected WebElement findElement(WebElement root, By locator) {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, locator));
        return driver.findElement(locator);
    }

    protected WebElement findElementFromRoot(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(WebElement root, By locator) {
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(root, locator));
        return root.findElements(locator);
    }

    protected Optional<WebElement> getElementIfPresent(WebElement root, By locator) {
        try {
            return Optional.of(root.findElement(locator));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    protected List<WebElement> readHeaderOptions() {
        return driver.findElements(By.className("header--nav-item"));
    }

    public CareersPage navigateToCurrentOpenings() {
        readHeaderOptions();
        WebElement careersDDL = readHeaderOptions().stream().filter(e -> e.getText().contains("Careers")).findFirst().orElse(null);
        actions.moveToElement(careersDDL).moveToElement(driver.findElement(By.xpath("//a[@href='/careers#current-openings']"))).click().build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("footer--bottom")));//wait until the footer of the page is loaded
        return new CareersPage(driver);
    }

    public AboutUsPage navigateToAboutUsPage() {
        readHeaderOptions();
        WebElement aboutUsBtn = readHeaderOptions().stream().filter(e -> e.getText().contains("About Us")).findFirst().orElse(null);
        if (aboutUsBtn != null) aboutUsBtn.click();
        return new AboutUsPage(driver);
    }

}
