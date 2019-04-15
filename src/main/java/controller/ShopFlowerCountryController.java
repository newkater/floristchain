package controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import configuration.Constants;
import configuration.DatabaseUtils;
import io.javalin.Context;
import model.ShopFlowerCountry;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class ShopFlowerCountryController {
    private static Dao<ShopFlowerCountry, Long> dao;
    private static Logger logger;

    public static void getAll(@NotNull Context context) {
        try {
            context.json(dao.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getOne(@NotNull Context context, @NotNull String s) {
        long flowerId = Long.valueOf(s);
        try {
            ShopFlowerCountry shopFlowerCountry = dao.queryForId(flowerId);
            if (shopFlowerCountry != null) {
                context.json(shopFlowerCountry);
            } else {
                context.status(Constants.NOT_FOUND_404);
            }
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public void create(@NotNull Context context) {
        ShopFlowerCountry shopFlowerCountry = context.bodyAsClass(ShopFlowerCountry.class);
        try {
            dao.create(shopFlowerCountry);
            context.status(Constants.CREATED_201);
        } catch (SQLException e) {
            logger.error("Error occurred saving record");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public void delete(@NotNull Context context, @NotNull String s) {
        long shopFlowerCountryId = Long.valueOf(s);
        try {
            dao.deleteById(shopFlowerCountryId);
        } catch (SQLException e) {
            logger.error("Error occurred deleting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public void update(@NotNull Context context, @NotNull String s) {
        long countryCityId = Long.valueOf(s);
        ShopFlowerCountry newShopFlowerCountry = context.bodyAsClass(ShopFlowerCountry.class);
        newShopFlowerCountry.setShopFlowerCountryId(countryCityId);
        try {
            dao.update(newShopFlowerCountry);
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    static {
        logger = LoggerFactory.getLogger(FlowerController.class);
        try {
            dao = DaoManager.createDao(DatabaseUtils.getSourse(), ShopFlowerCountry.class);
        } catch (SQLException e) {
            logger.error("Error creating DAO");
        }
    }
}
