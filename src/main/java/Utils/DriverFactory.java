package Utils;

import Enums.DriverTypeEnum;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    public static WebDriver createDriverForSpecificBrowser(DriverTypeEnum driverType) {
        String driverVersion = PropertiesReader.readFromProperties(ConfigurationConstants.TESTING_PROPERTIES_PATH, ConfigurationConstants.DRIVER_TYPE_VERSION);
        WebDriver driver = null;
        if (driverType.equals(DriverTypeEnum.GOOGLE_CHROME_DRIVER)) {
            ChromeDriverManager.getInstance().version(driverVersion).setup();
            driver = new ChromeDriver();
        }
        if (driverType.equals(DriverTypeEnum.GOOGLE_CHROME_DRIVER_HEADLESS)) {
            ChromeDriverManager.getInstance().version(driverVersion).setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("window-size=1920x1080");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--allow-insecure-localhost");
            driver = new ChromeDriver(chromeOptions);
        }
        if (driverType.equals((DriverTypeEnum.FIREFOX_DRIVER))) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            FirefoxDriverManager.getInstance().version(driverVersion).setup();
            driver = new FirefoxDriver();
        }
        if (driver == null) {
            throw new NullPointerException("Driver failed to initialise!");
        }
        driver.manage().window().maximize();
        return driver;
    }

    private DriverFactory() {
        throw new IllegalStateException("Utility class");
    }
}
