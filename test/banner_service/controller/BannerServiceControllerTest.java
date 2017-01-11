package banner_service.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import static org.junit.Assert.*;

/**
 * Created by svindler on 10.01.2017.
 */

public class BannerServiceControllerTest {

    private static String localhost = "http://localhost:60000";
    
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


    @org.junit.Test
    public void getBannerWithNull() throws Exception {
        HttpResponse response = Request.Post(localhost + "/banner")
                .execute().returnResponse();
        System.out.println(Request.Post(localhost + "/banner").execute());

        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        JSONObject jsonObject = new JSONObject(responseString);
        assertEquals("Empty request body", jsonObject.get("error"));

    }

    @org.junit.Test
    public void testErrorCodeWhenRequestBodyIsNull() throws Exception {
        HttpResponse response = Request.Post(localhost + "/banner")
                .execute().returnResponse();
        assertEquals(400, response.getStatusLine().getStatusCode());

    }

}