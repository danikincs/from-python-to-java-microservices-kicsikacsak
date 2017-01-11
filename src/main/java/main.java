import server_controller.ServerController;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.*;
import static spark.Spark.get;


/**
 * Created by svindler on 11.01.2017.
 */
public class main {
    public static void main(String[] args) {

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        get("/banner", ServerController::renderProducts, new ThymeleafTemplateEngine());

        get("/hello", (req, res) -> "Hello World");
    }
}
