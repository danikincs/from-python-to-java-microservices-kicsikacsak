package server_controller;

import banner_service.controller.BannerController;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by svindler on 11.01.2017.
 */
public class ServerController {
    public static ModelAndView renderProducts(Request req, Response res) {

        Map<Object, Object> params = new HashMap<>();

        BannerServiceController bannerServiceController = new BannerServiceController();
        try {
            params.put("banner", bannerServiceController.getBanner());
        }catch (IOException | URISyntaxException e) {
            System.out.print(e);
        }

        return new ModelAndView(params, "html/index");
    }
}
