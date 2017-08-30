package package3;

import package1.Mail;
import package2.MailClient;

/**
 * Created by Anakinliu on 2017/2/4.
 * GO! GO! GO!
 */
public class MyMailClient extends MailClient {
    Mail getCore() {
        return this.new MailCore();
    }
}
