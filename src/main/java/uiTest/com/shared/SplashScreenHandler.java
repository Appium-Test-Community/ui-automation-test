package uiTest.com.shared;

import io.appium.java_client.AppiumDriver;
import uiTest.com.traveloka.shared.AppPage;

/**
 * Created by haekalwiralegawa on 2020-05-03.
 */

public class SplashScreenHandler extends AppPage {
    public SplashScreenHandler(AppiumDriver driver) {
        super(driver);
    }

    /*
        Page Object
     */


    /*
        Function
     */

    public void handleSplashScreenWhenStartUp(String appName) {
        switch (appName.toLowerCase()) {
            case "traveloka" :
                handleTravelokaSplashScreen();
                break;
            case "tokopedia" :
                handleTokopediaSplashScreen();
                break;
        }
    }

    private void handleTravelokaSplashScreen() {

    }

    private void handleTokopediaSplashScreen() {

    }
}
