package banner_service.Service;

import org.json.JSONObject;

/**
 * Created by svindler on 10.01.2017.
 */
public class Service {

    private static Service instance;

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }

    public JSONObject getBanner(){
        JSONObject obj = new JSONObject();
        obj.put("user","null");
        obj.put("cart", "null");
        obj.put("Advertisement", "sent");
        return obj;
    }

    public JSONObject getBanner(String user) {
        JSONObject obj = new JSONObject();
        obj.put("user", user);
        obj.put("cart", "null");
        obj.put("sugg", "sent");
        return obj;
    }

    public JSONObject getBanner(String user, String cart) {
        JSONObject obj = new JSONObject();
        obj.put("user", user);
        obj.put("cart", cart);
        obj.put("suggestion", "sent");
        return obj;
    }
}
