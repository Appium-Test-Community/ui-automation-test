package uiTest.com.utils;

import java.io.IOException;

import static uiTest.com.shared.BaseDriver.*;

/**
 * Created by haekalwiralegawa on 2020-05-02.
 */

public class PropertiesUtils {
    protected ConfigUtils configUtils = new ConfigUtils();

    public String getPlatform() {
        try {
            return (System.getProperty("testPlatform") == null) ? configUtils.getConfig("platform") : System.getProperty("testPlatform");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return platform;
    }

    public String getDeviceName() {
        try {
            if (System.getProperty("testDevice") == null) {
                if (platform.equalsIgnoreCase("android"))
                    return configUtils.getConfig("device.android.name");
                else
                    return configUtils.getConfig("device.ios.name");
            } else {
                return System.getProperty("testDevice");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deviceName;
    }

    public String getPlatformVersion() {
        try {
            if (System.getProperty("testPlatformVersion") == null) {
                if (platform.equalsIgnoreCase("android")) {
                    return configUtils.getConfig("device.android.version");
                } else {
                    return configUtils.getConfig("device.ios.version");
                }
            } else {
                return System.getenv("testPlatformVersion");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return platformVersion;
    }

    public String getAppiumUrl() {
        try {
            return (System.getProperty("appiumServer") == null) ? configUtils.getConfig("server.url") : "http://localhost:" + System.getProperty("appiumServer") + "/wd/hub";
        }catch (Exception e) {
            e.printStackTrace();
        }
        return appiumUrl;
    }

}
