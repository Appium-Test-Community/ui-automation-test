package uiTest.com.traveloka.User.testsuites;

import org.testng.annotations.Test;
import uiTest.com.shared.EmailUtils;
import uiTest.com.traveloka.shared.TravelokaBaseDriver;

/**
 * Created by haekalwiralegawa on 2020-05-03.
 */

public class testLoginTraveloka extends TravelokaBaseDriver {

    @Test
    public void testLogin() throws Exception{
        System.out.println("Coba aja");
        EmailUtils emailUtils = new EmailUtils();
//        System.out.println(emailUtils.getOTP("imap.gmail.com",993, "ujiperang@gmail.com","h28w7qtqgwiw8w"));
        System.out.println(emailUtils.getOTP("imap.gmail.com",993, "prodtvlktest@gmail.com","traveloka123"));
    }

}
