package package2;

import package1.Mail;

/**
 * Created by Anakinliu on 2017/2/4.
 * GO! GO! GO!
 */
public class MailClient {
    protected class MailCore implements Mail{
        @Override
        public void sentMail() {
            System.out.println("Mail.Client.sentMail()");
        }
    }
}
