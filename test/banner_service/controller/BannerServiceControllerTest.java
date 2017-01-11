package banner_service.controller;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONObject;

import java.net.URI;

import static org.junit.Assert.*;

/**
 * Created by svindler on 10.01.2017.
 */
public class BannerServiceControllerTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getBannerWithNullUser() throws Exception {
        URI uri = new URIBuilder("http://localhost:60000/banner").build();
        String rawString = Request.Get(uri).execute().returnContent().asString();
        JSONObject json = new JSONObject(rawString);
        assertEquals("null", json.get("user"));
    }

    @org.junit.Test
    public void getBannerWithUser() throws Exception {
        URI uri = new URIBuilder("http://localhost:60000/banner?user=user").build();
        String rawString = Request.Get(uri).execute().returnContent().asString();
        JSONObject json = new JSONObject(rawString);
        assertEquals("user", json.get("user"));
    }

    @org.junit.Test
    public void getBannerWithUserAndCart() throws Exception {
        URI uri = new URIBuilder("http://localhost:60000/banner?user=user&cart=cart").build();
        String rawString = Request.Get(uri).execute().returnContent().asString();
        JSONObject json = new JSONObject(rawString);
        assertEquals("cart", json.get("cart"));
    }

}