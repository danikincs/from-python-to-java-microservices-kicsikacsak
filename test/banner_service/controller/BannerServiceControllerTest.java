package banner_service.controller;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import static org.junit.Assert.*;

/**
 * Created by svindler on 10.01.2017.
 */

public class BannerServiceControllerTest {

    private static String  localhost = "http://localhost:60000";

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getBannerWithNullUser() throws Exception {
        String rawString = Request.Post(localhost  + "/banner").addHeader("details", "{}")
                .execute().returnContent().asString();

        JSONObject json = new JSONObject(rawString);
        assertEquals("null", json.get("user"));
    }

    @org.junit.Test
    public void getBannerWithUser() throws Exception {

        String rawString = Request.Post(localhost + "/banner").addHeader("details", "{user:user}")
                .execute().returnContent().asString();

        JSONObject json = new JSONObject(rawString);
        assertEquals("user", json.get("user"));
    }

    @org.junit.Test
    public void getBannerWithUserAndCart() throws Exception {
        String rawString = Request.Post(localhost + "/banner").addHeader("details", "{user:user, cart:cart}")
                .execute().returnContent().asString();

        JSONObject json = new JSONObject(rawString);
        assertEquals("cart", json.get("cart"));
    }

}