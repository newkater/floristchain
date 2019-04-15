import configuration.Constants;
import configuration.JacksonUtils;
import controller.*;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().enableDebugLogging().port(Constants.PORT);
        JavalinJackson.configure(JacksonUtils.getMapper());

        app.get("/city",ctx -> CityController.getAll(ctx));
        app.post("/city", ctx -> CityController.create(ctx));
        app.get("/city/:id",ctx -> CityController.getOne(ctx, ctx.pathParam("id")));
        app.patch("city/:id", ctx -> CityController.update(ctx, ctx.pathParam("id")));
        app.delete("city/:id", ctx -> CityController.delete(ctx, ctx.pathParam("id")));

        app.get("/cityshop",ctx -> CityShopController.getAll(ctx));
        app.post("/cityshop", ctx -> CityShopController.create(ctx));
        app.get("/cityshop/:id",ctx -> CityShopController.getOne(ctx, ctx.pathParam("id")));
        app.patch("cityshop/:id", ctx -> CityShopController.update(ctx, ctx.pathParam("id")));
        app.delete("cityshop/:id", ctx -> CityShopController.delete(ctx, ctx.pathParam("id")));

        app.get("/country",ctx -> CountryController.getAll(ctx));
        app.post("/country", ctx -> CountryController.create(ctx));
        app.get("/country/:id",ctx -> CountryController.getOne(ctx, ctx.pathParam("id")));
        app.patch("country/:id", ctx -> CountryController.update(ctx, ctx.pathParam("id")));
        app.delete("country/:id", ctx -> CountryController.delete(ctx, ctx.pathParam("id")));

        app.get("/countrycity",ctx -> CountryCityController.getAll(ctx));
        app.post("/countrycity", ctx -> CountryCityController.create(ctx));
        app.get("/countrycity/:id",ctx -> CountryCityController.getOne(ctx, ctx.pathParam("id")));
        app.patch("countrycity/:id", ctx -> CountryCityController.update(ctx, ctx.pathParam("id")));
        app.delete("countrycity/:id", ctx -> CountryCityController.delete(ctx, ctx.pathParam("id")));

        app.get("/flower",ctx -> FlowerController.getAll(ctx));
        app.post("/flower/create", ctx -> FlowerController.create(ctx));
        app.get("/flower/:id",ctx -> FlowerController.getOne(ctx, ctx.pathParam("id")));
        app.patch("flower/:id", ctx -> FlowerController.update(ctx, ctx.pathParam("id")));
        app.delete("flower/:id", ctx -> FlowerController.delete(ctx, ctx.pathParam("id")));

        app.get("/shop",ctx -> ShopController.getAll(ctx));
        app.post("/shop/create", ctx -> ShopController.create(ctx));
        app.get("/shop/:id",ctx -> ShopController.getOne(ctx, ctx.pathParam("id")));
        app.patch("shop/:id", ctx -> ShopController.update(ctx, ctx.pathParam("id")));
        app.delete("shop/:id", ctx -> ShopController.delete(ctx, ctx.pathParam("id")));

        app.get("/shopflowercountry",ctx -> ShopFlowerCountryController.getAll(ctx));
        app.post("/shopflowercountry/create", ctx -> ShopFlowerCountryController.create(ctx));
        app.get("/shopflowercountry/:id",ctx -> ShopFlowerCountryController.getOne(ctx, ctx.pathParam("id")));
        app.patch("shopflowercountry/:id", ctx -> ShopFlowerCountryController.update(ctx, ctx.pathParam("id")));
        app.delete("shopflowercountry/:id", ctx -> ShopFlowerCountryController.delete(ctx, ctx.pathParam("id")));
        app.start();
    }
}
