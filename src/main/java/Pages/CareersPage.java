package Pages;

import Models.OpenPosition;
import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CareersPage extends BasePage {

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    private List<OpenPosition> openPositionList;

    @FindBy(className = "currentOpenings--jobs")
    private WebElement openPositionsLocator;
    @FindBy(className = "currentOpenings--job-link")
    private WebElement positionLocator;

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new CareersPage(driver);
    }

    public void readOpenPositions() {
        openPositionList = new ArrayList<>();
        List<WebElement> openPositionsLocatorsList = findElements(openPositionsLocator, By.className("currentOpenings--job-link"));
        openPositionsLocatorsList.forEach(position -> openPositionList.add(readOpenPositionDetails(position)));

    }

    public OpenPosition readOpenPositionDetails(WebElement position) {
        String type = position.findElement(By.className("currentOpenings--job-type")).getText();
        String title = position.findElement(By.className("currentOpenings--job-title")).getText();
        String location = position.findElement(By.className("currentOpenings--job-locationWrapper")).getText();
        return OpenPosition.builder()
                .type(type)
                .title(title)
                .location(location)
                .build();
    }

    public List<OpenPosition> getOpenPositionList() {
        return openPositionList;
    }
}
