package uiTest.com.tokopedia.shared;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import uiTest.com.shared.BaseDriver;
import uiTest.com.shared.SplashScreenHandler;
import uiTest.com.utils.CapabilitiesSetup;

import java.io.IOException;

/**
 * Created by haekalwiralegawa on 2020-05-03.
 */

public class TokopediaBaseDriver extends BaseDriver {
    CapabilitiesSetup capabilitiesSetup;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        serverUrl = configUtils.getConfig("server.url");
        activity = configUtils.getConfig("app.android.activity.tokopedia");
        appFileName = configUtils.getConfig("app.android.file.tokopedia");
        appPackage = configUtils.getConfig("app.android.package.tokopedia");

        capabilitiesSetup = new CapabilitiesSetup();
        capabilitiesSetup.initCapabilities(serverUrl,activity,appFileName,appPackage);
        configuration = capabilitiesSetup.getConfigurations();

        driver = capabilitiesSetup.startDriver();

        SplashScreenHandler splashScreenHandler = new SplashScreenHandler(driver);
        splashScreenHandler.handleSplashScreenWhenStartUp("Tokopedia");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public AppiumDriver<WebElement> getDriver() {
        return this.driver;
    }
}
