package package2;

import package1.Mail;

/**
 * Created by Anakinliu on 2017/2/4.
 * GO! GO! GO!
 */
public class MailClient {
    protected class MailCore implements Mail{
        //有了public构造方法才能在其他的包中package3创建MailCore对象
        public MailCore() {}

        @Override
        public void sentMail() {
            System.out.println("Mail.Client.sentMail()");
        }
    }
}
