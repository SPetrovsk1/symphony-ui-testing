package Pages;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AboutUsPage extends BasePage {

    private Map<String, String> metaDataMap;

    @FindBy(className = "pageMetaDetails")
    private WebElement metaDataLocator;

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage newInstance(WebDriver driver) {
        return new AboutUsPage(driver);
    }

    public void readMetaData() {
        metaDataMap = new HashMap<>();
        List<WebElement> topics = findElements(metaDataLocator, By.tagName("li"));
        //For each topic, adds the name in the map as a key, and the text as a value. Paragraphs with more than one row have their values split by comma.
        topics.forEach(topic -> metaDataMap.put(topic.getText().split("\\n")[0], topic.findElement(By.className("prop--content")).getText().replaceAll("\\n", ",")));
    }


    public void assertMetaDataValues(SoftAssert softAssert, Map<String, String> metaDataMap) {
        softAssert.assertEquals(metaDataMap.get("HQ"), "San Francisco", "HQ value not ok!");
        softAssert.assertEquals(metaDataMap.get("Founded"), "2007","Founded value not ok!");
        softAssert.assertEquals(metaDataMap.get("Size"), "450+","Size value not ok!");
        softAssert.assertEquals(metaDataMap.get("Consulting Offices"), "Amsterdam,Berlin,Copenhagen,London,Denver,Zurich","Consulting offices values not ok!");
        softAssert.assertEquals(metaDataMap.get("Engineering Hubs"), "Sarajevo,Belgrade,Skopje,Novi Sad,Nis","Engineering hubs values not ok!");
        softAssert.assertEquals(metaDataMap.get("Clients"), "100+","Clients value not ok!");
    }

    public Map<String, String> getMetaData() {
        return metaDataMap;
    }

}
