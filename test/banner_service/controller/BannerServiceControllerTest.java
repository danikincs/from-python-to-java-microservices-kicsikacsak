package banner_service.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.junit.Assert;
import spark.Response;

import static org.junit.Assert.*;

/**
 * Created by svindler on 10.01.2017.
 */

public class BannerServiceControllerTest {

    private static String localhost = "http://localhost:60000";

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getBannerWithEmptyJson() throws Exception {
        StringEntity jsonstring = new StringEntity("{}");

        String rawString = Request.Post(localhost  + "/banner").body(jsonstring)
                .execute().returnContent().asString();

        JSONObject json = new JSONObject(rawString);
        assertEquals("null", json.get("user"));
    }

    @org.junit.Test
    public void getBannerWithUser() throws Exception {
        StringEntity jsonstring = new StringEntity("{user:user}");

        String rawString = Request.Post(localhost + "/banner").body(jsonstring)
                .execute().returnContent().asString();

        JSONObject json = new JSONObject(rawString);
        assertEquals("user", json.get("user"));
    }

    @org.junit.Test
    public void getBannerWithUserAndCart() throws Exception {
        StringEntity jsonstring = new StringEntity("{user:user, cart:cart}");

        String rawString = Request.Post(localhost + "/banner").body(jsonstring)
                .execute().returnContent().asString();

        JSONObject json = new JSONObject(rawString);
        assertEquals("cart", json.get("cart"));
    }


    @org.junit.Test (expected = HttpResponseException.class)
    public void getBannerWithNull() throws Exception {
        Request.Post(localhost + "/banner")
                .execute().returnContent().asString();
    }

}