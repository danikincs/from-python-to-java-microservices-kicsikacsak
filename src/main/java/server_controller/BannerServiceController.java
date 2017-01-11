package server_controller;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import java.io.IOException;

import java.net.URISyntaxException;

/**
 * Created by svindler on 11.01.2017.
 */
public class BannerServiceController {

    private static final String SERVICE_URL = "http://localhost:60000";

    public String getBanner() throws URISyntaxException, IOException {
        StringEntity jsonstring = new StringEntity("{}");

        return Request.Post(SERVICE_URL + "/banner").body(jsonstring)
                .execute().returnContent().asString();
    }

}
