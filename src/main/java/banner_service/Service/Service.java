package banner_service.Service;

import org.json.JSONObject;

/**
 * Created by svindler on 10.01.2017.
 */
public class Service {

    private static Service instance;
    private static String HTML = "<div class=\"container\">" +
            "<div class=\"col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3\">" +
            "<a href=\"https://codecool.hu/\"><img src=\"http://www.auplod.com/u/opladu8f6e7.gif\" border=\"1\">" +
            "</a></div></div>";

    private Service() {
    }

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }

    public JSONObject getBanner(){
        JSONObject obj = new JSONObject();
        obj.put("status","done");
        obj.put("Advertisement", HTML);
        return obj;
    }

    public JSONObject getBanner(String user) {
        JSONObject obj = new JSONObject();

        obj.put("status", "done");
        return obj;
    }

    public JSONObject getBanner(String user, String cart) {
        JSONObject obj = new JSONObject();
        obj.put("status", "done");
        return obj;
    }
}
