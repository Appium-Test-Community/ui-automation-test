package uiTest.com.shared;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import uiTest.com.traveloka.shared.OnBoardingPageHandler;
import uiTest.com.utils.CapabilitiesSetup;
import uiTest.com.utils.ConfigUtils;
import uiTest.com.utils.PropertiesUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haekalwiralegawa on 2020-05-02.
 */

public class BaseDriver {
    protected AppiumDriver<WebElement> driver;
    protected static ConfigUtils configUtils = new ConfigUtils();
    protected  static PropertiesUtils propertiesUtils = new PropertiesUtils();
    private static OnBoardingPageHandler onBoardingPageHandler;
    protected String serverUrl, activity, appFileName, appPackage;

    /*
        SETUP PLATFORM
     */
    public static String platform = propertiesUtils.getPlatform();
    public static String deviceName = propertiesUtils.getDeviceName();
    public static String platformVersion = propertiesUtils.getPlatformVersion();
    public static String appiumUrl = propertiesUtils.getAppiumUrl();

    public Map<String, String> configuration = new HashMap<String, String>();
}
