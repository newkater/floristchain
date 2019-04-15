import configuration.Constants;
import configuration.JacksonUtils;
import controller.*;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;
import model.ShopFlowerCountry;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().enableDebugLogging().port(Constants.PORT);
        JavalinJackson.configure(JacksonUtils.getMapper());

        app.get("/city",ctx -> CityController.getAll(ctx));
        app.get("/city/:id",ctx -> CityController.getOne(ctx, ctx.pathParam("id")));

        app.get("/cityshop",ctx -> CityShopController.getAll(ctx));
        app.get("/cityshop/:id",ctx -> CityShopController.getOne(ctx, ctx.pathParam("id")));

        app.get("/country",ctx -> CountryController.getAll(ctx));
        app.get("/country/:id",ctx -> CountryController.getOne(ctx, ctx.pathParam("id")));

        app.get("/countrycity",ctx -> CountryCityController.getAll(ctx));
        app.get("/countrycity/:id",ctx -> CountryCityController.getOne(ctx, ctx.pathParam("id")));

        app.get("/flower",ctx -> FlowerController.getAll(ctx));
        app.get("/flower/:id",ctx -> FlowerController.getOne(ctx, ctx.pathParam("id")));

        app.get("/shop",ctx -> ShopController.getAll(ctx));
        app.get("/shop/:id",ctx -> ShopController.getOne(ctx, ctx.pathParam("id")));

        app.get("/shopflowercountry",ctx -> ShopFlowerCountryController.getAll(ctx));
        app.get("/shopflowercountry/:id",ctx -> ShopFlowerCountryController.getOne(ctx, ctx.pathParam("id")));
        app.start();
    }
}
