package uiTest.com.traveloka.shared;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import uiTest.com.shared.BaseDriver;
import uiTest.com.shared.SplashScreenHandler;
import uiTest.com.utils.CapabilitiesSetup;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

/**
 * Created by haekalwiralegawa on 2020-05-02.
 */

public class TravelokaBaseDriver extends BaseDriver {
    CapabilitiesSetup capabilitiesSetup;

    @BeforeClass
    public void setUp() throws IOException, InterruptedException {
        serverUrl = configUtils.getConfig("server.url");
        activity = configUtils.getConfig("app.android.activity.traveloka");
        appFileName = configUtils.getConfig("app.android.file.traveloka");
        appPackage = configUtils.getConfig("app.android.package.traveloka");

        capabilitiesSetup = new CapabilitiesSetup();
        capabilitiesSetup.initCapabilities(serverUrl,activity,appFileName,appPackage);
        configuration = capabilitiesSetup.getConfigurations();

        driver = capabilitiesSetup.startDriver();

        SplashScreenHandler splashScreenHandler = new SplashScreenHandler(driver);
        splashScreenHandler.handleSplashScreenWhenStartUp("Traveloka");
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
