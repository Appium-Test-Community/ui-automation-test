package uiTest.com.traveloka.shared;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by haekalwiralegawa on 2020-05-03.
 */

public class AppPage extends TravelokaBaseDriver {
    protected final AppiumDriver driver;

    public AppPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }
}
