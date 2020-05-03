package uiTest.com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by haekalwiralegawa on 2020-05-02.
 */

public class ConfigUtils {
    private Properties properties = new Properties();
    private static final String configPropFileName = "src/main/java/uiTest/com/shared/config.properties";
    private InputStream inputStream;

    public String getConfig(String key) throws IOException {
        inputStream = new FileInputStream(new File(configPropFileName));
        properties.load(inputStream);

        return properties.getProperty(key);
    }

}
