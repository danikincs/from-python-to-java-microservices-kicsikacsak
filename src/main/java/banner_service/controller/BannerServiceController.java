package banner_service.controller;

import banner_service.Service.Service;
import org.json.JSONObject;
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

    public JSONObject getBanner(Request request, Response response) {
        if(request.queryParams("user") == null) {
            return service.getBanner();
//            return "do something with null user";
        }else if (request.queryParams("cart") == null && request.queryParams("user") != null ) {
            return service.getBanner(request.queryParams("user"));
//            return "do something with user, and null cart";
        }
        return service.getBanner(request.queryParams("user"), request.queryParams("cart"));
//        return "OK BITHCES";
    }
}
