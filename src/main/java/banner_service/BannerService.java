package banner_service;

import banner_service.Service.Service;
import banner_service.controller.BannerServiceController;

import java.net.URISyntaxException;

import static spark.Spark.exception;
import static spark.Spark.port;

/**
 * Created by svindler on 10.01.2017.
 */

public class BannerService {

    private BannerServiceController controller;

    public static void main(String args[]) {

        setup(args);
        System.out.println(args[0]);

        BannerService application = new BannerService();

        application.controller = new BannerServiceController(Service.getInstance());

        // --- MAPPINGS ---
//        get("/status", application.controller::status);
//        get("/api/random", application.controller::random);
//        get("/api/categories", application.controller::categories);

        // --- EXCEPTION HANDLING ---
        exception(URISyntaxException.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("URI building error, maybe wrong format? : %s", exception.getMessage()));
        });

        exception(Exception.class, (exception, request, response) -> {
            response.status(500);
            response.body(String.format("Unexpected error occurred: %s", exception.getMessage()));
        });
    }

    /**
     * Setting up port
     * @param args - app args
     */
    private static void setup(String[] args){
        if(args == null || args.length == 0){
            System.exit(-1);
        }

        try {
            port(Integer.parseInt(args[0]));
        } catch (NumberFormatException e){
            System.exit(-1);
        }
    }
}
