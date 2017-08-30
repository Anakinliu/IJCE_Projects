import com.opensymphony.xwork2.ActionSupport;

import java.text.DateFormat;
import java.util.Date;


/**
 * Created by Anakinliu on 2017/8/11.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class HelloWorld extends ActionSupport {
    private String message;

    public String getMessage() {
        return message;
    }

    public String execute() {
        message = "Hello World, Now is " +
                DateFormat.getDateInstance().format(new Date());
        return SUCCESS;
    }
}
