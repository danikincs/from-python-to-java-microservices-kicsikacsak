package banner_service.controller;

import banner_service.Service.Service;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONPointerException;
import spark.Request;
import spark.Response;

/**
 * Created by svindler on 10.01.2017.
 */
public class BannerServiceController {

    private final Service service;

    public BannerServiceController(Service service){
        this.service = service;
    }

    public JSONObject getBanner(Request request, Response response){
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(request.headers("details"));
        }catch (JSONException | NullPointerException e) {

            System.out.println("String cannot be converted into a JSON object or its null" + e);
        }

        System.out.println(jsonObject);

        if(jsonObject.length() == 0) {
            return service.getBanner();

        }else if (!jsonObject.has("cart")) {
            return service.getBanner(jsonObject.get("user").toString());

        }
        return service.getBanner(jsonObject.get("user").toString(), jsonObject.get("cart").toString());
//        return "OK BITHCES";
    }
}
