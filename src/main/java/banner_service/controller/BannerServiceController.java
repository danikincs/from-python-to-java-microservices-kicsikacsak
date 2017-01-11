package banner_service.controller;

import banner_service.Service.Service;
import db_connector.DataBaseConnectorImpl;
import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by svindler on 10.01.2017.
 */
public class BannerServiceController {

    private final Service service;
    private static DataBaseConnectorImpl connector = DataBaseConnectorImpl.getInstance();

    public BannerServiceController(Service service) {
        this.service = service;
    }

    public JSONObject getBanner(Request request, Response response) {
        if (request.queryParams("user") == null) {
            return service.getBanner();
//            return "do something with null user";
        } else if (request.queryParams("cart") == null && request.queryParams("user") != null) {
            return service.getBanner(request.queryParams("user"));
//            return "do something with user, and null cart";
        }
        return service.getBanner(request.queryParams("user"), request.queryParams("cart"));
//        return "OK BITHCES";
    }

    public boolean checkClientAPIKEY(String jsonStr) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonStr);
        String apikey = jsonObject.getString("apikey");

        String query = "SELECT * FROM client WHERE apikey = ? ;";

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query))

        {
            statement.setString(1, apikey);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Client APIKey found");
                return true;

            } else {
                System.out.println("No APIKey was found");
                return false;
            }

        } catch (SQLException | JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}