package Utils;


public class ConfigurationConstants {

    public static final int MAX_RETRY_PERIOD_AJAX_FACTORY = 20;
    public static final int MAX_RETRY_FOR_LOCATING_ELEMENT = 10;

    public static final String BASE_URL = "https://symphony.is/";

    public static final String TESTING_PROPERTIES_PATH = "testing.properties";
    public static final String BASE_URL_PROPERTY = "base.url";
    public static final String DRIVER_TYPE_PROPERTY = "browser.type";
    public static final String DRIVER_TYPE_VERSION = "driver.version";

    private ConfigurationConstants() {
        throw new IllegalStateException("Utility class");
    }

}
