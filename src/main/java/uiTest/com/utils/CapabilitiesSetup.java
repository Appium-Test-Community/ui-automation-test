package uiTest.com.utils;

import uiTest.com.shared.BaseDriver;
import uiTest.com.traveloka.shared.TravelokaBaseDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by haekalwiralegawa on 2020-05-02.
 */

public class CapabilitiesSetup extends BaseDriver {
    AndroidDriver<WebElement> androidDriver;
    IOSDriver<WebElement> iosDriver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    String serverUrl, projDir, appPath, activity, appFileName, appPackage;

    public AppiumDriver<WebElement> startDriver() throws IOException, InterruptedException {
        AppiumDriver<WebElement> driver = null;
        if (configuration.get("platformName").equalsIgnoreCase("android")) {
            capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
//            projDir = System.getProperty("user.dir") + "/src/main/resources/app";
//            appPath = Paths.get(projDir, appFileName).toAbsolutePath().toString();
//            capabilities.setCapability(MobileCapabilityType.APP, appPath);
            androidDriver= new AndroidDriver<>(new URL(serverUrl), capabilities);
            Thread.sleep(5000);
            androidDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver = androidDriver;
        }
        return driver;
    }
    public Map<String, String> getConfigurations(){
        return configuration;
    }

    public void initCapabilities(String serverUrlCaps, String activityCaps, String appFileNameCaps, String appPackageCaps) throws IOException{
        serverUrl = serverUrlCaps;
        activity = activityCaps;
        appFileName = appFileNameCaps;
        appPackage = appPackageCaps;

        configuration.put("platformName", platform);
        configuration.put("platformVersion", platformVersion);
        configuration.put("deviceName", deviceName);
        configuration.put("serverPort",configUtils.getConfig("server.port"));

        if (configuration.get("platformName").equalsIgnoreCase("android")) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, configuration.get("platformVersion"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configUtils.getConfig("driver.android"));
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackageCaps);
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activity);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configuration.get("deviceName"));
            capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, configUtils.getConfig("permission.android"));
            capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.valueOf(configuration.get("serverPort")));
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30000);
        }

    }

}
