package banner_service.Service;

import org.json.JSONObject;

/**
 * Created by svindler on 10.01.2017.
 */

/**
 * This class contains the main api logic
 *
 * @author danikincs
 * @version 1.0
 */

public class Service {

    private static Service instance;
    private static String basic_banner_HTML = "<div class=\"container\">" +
            "<div class=\"col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3\">" +
            "<a href=\"https://codecool.hu/\"><img src=\"http://www.auplod.com/u/opladu8f6e7.gif\" border=\"1\">" +
            "</a></div></div>";

    private static String customer_HTML = "<div class=\"container\">" +
            "<div class=\"col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3\">" +
            "<a href=\"https://codecool.hu/\"><img src=\"http://www.auplod.com/u/aoludp8f70b.gif\" border=\"1\">" +
            "</a></div></div>";

    private Service() {
    }

    public static Service getInstance(){
        if (instance == null){
            instance = new Service();
        }
        return instance;
    }

    /**
     * Simpliest advertisement method
     * @return a Jsonobject with status and Advertisement keys.
     */
    public JSONObject getBanner(){
        JSONObject obj = new JSONObject();
        obj.put("status","done");
        obj.put("Advertisement", basic_banner_HTML);
        return obj;
    }

    /**
     * Advertisement getter method with a parameter
     * NOT IMPLEMENTED YET
     * @param user which is a string from the request
     * @return a Jsonobject with status and Advertisement keys.
     */
    public JSONObject getBanner(String user) {
        JSONObject obj = new JSONObject();
        obj.put("Advertisement", customer_HTML);
        obj.put("status", "done");
        return obj;
    }

    /**
     * Advertisementgetter method with two parameters
     * NOT IMPLEMENTED YET
     * @param user which is a string from the request
     * @param cart which is a string from the request
     * @return a Jsonobject with status and Advertisement keys.
     */
    public JSONObject getBanner(String user, String cart) {
        JSONObject obj = new JSONObject();
        obj.put("Advertisement", customer_HTML);
        obj.put("status", "done");
        return obj;
    }
}
