package uiTest.com.shared;


import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.util.Properties;

/**
 * Created by haekalwiralegawa on 2020-05-03.
 */

public class EmailUtils {

    public String getOTP(String host,
                         int port,
                         String user,
                         String password) throws Exception {
        String otp=null;
        Session session = Session.getDefaultInstance(new Properties());
        Store store = session.getStore("imaps");
        store.connect(host, port, user, password);
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);

        //fetch Unseen Message from inbox
        Message[] messages = inbox.search(
                new FlagTerm(new Flags(Flags.Flag.RECENT), false)
        );

        for (int i=messages.length-1, n = messages.length-2;i > n; i--){
            Message message = messages[i];
            otp = getTextFromMessage(message);
            message.setFlag(Flags.Flag.RECENT, true);
        }
        return otp;
    }

    /**
     * Extracts the text content of an email message with support for multipart
     * messages
     */
    private String getTextFromMessage(Message message) throws Exception {
        String result = "";
        if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        } else {
            Object content = message.getContent();
            result = content.toString();
        }

        return result;
    }

    /**
     * Extracts the text content of a multipart email message
     */
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        String result = "";
        int partCount = mimeMultipart.getCount();
        for (int i = 0; i < partCount; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = html;
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }
}
