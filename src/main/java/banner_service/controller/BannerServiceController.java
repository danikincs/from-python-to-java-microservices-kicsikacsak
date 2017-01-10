package banner_service.controller;

import banner_service.Service.Service;
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

    public void getBanner(Request request, Response response){}
}
