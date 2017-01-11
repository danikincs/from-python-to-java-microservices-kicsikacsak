package banner_service.controller;

import banner_service.Service.Service;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

/**
 * Created by svindler on 10.01.2017.
 */

public class BannerController {

    private final Service service;

    public BannerController(Service service){
        this.service = service;
    }

    public JSONObject getBanner(Request request, Response response){

        System.out.println(request.body());

        JSONObject jsonObject = null;

        if(request.body() != null && !request.body().isEmpty()) {

            jsonObject = new JSONObject(request.body());

            if(jsonObject.length() == 0) {
                return service.getBanner();

            }else if (!jsonObject.has("cart")) {
                return service.getBanner(jsonObject.get("user").toString());

            }
            return service.getBanner(jsonObject.get("user").toString(), jsonObject.get("cart").toString());

        }else if(request.body().isEmpty()) {
            System.out.println("itt vagyok éppen mostan");
            response.status(400);
            response.body(String.format("{errors:error}"));
            jsonObject = new JSONObject(response.body());
        }
        return jsonObject;

    }
}
