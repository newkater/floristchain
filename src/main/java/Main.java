import configuration.Constants;
import configuration.JacksonUtils;
import controller.FlowerController;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().enableDebugLogging().port(Constants.PORT);
        JavalinJackson.configure(JacksonUtils.getMapper());

        app.get("/flowers/:id",ctx -> FlowerController.getAll(ctx));
        app.start();
    }
}
