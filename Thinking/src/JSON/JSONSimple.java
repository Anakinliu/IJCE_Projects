package JSON;

import org.json.JSONObject;
import Generics.GenericMethods;
/**
 * Created by Anakinliu on 2017/5/2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class JSONSimple {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        JSONObject jsonObject1 = new JSONObject();

        jsonObject1.put("tel", "124123414");

        jsonObject.put("name", "FillingKe");
        jsonObject.put("age", 12);
        jsonObject.put("job", new String[]{"coder", "volunteer"});
        jsonObject.put("others", jsonObject1);
        jsonObject.put("self",JSONObject.NULL);

        System.out.println(jsonObject.toString());

    }
}
