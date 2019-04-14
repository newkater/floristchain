package controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import configuration.Constants;
import configuration.DatabaseUtils;
import io.javalin.Context;
import model.Shop;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class ShopController {
    private static Dao<Shop, Long> dao;
    private static Logger logger;

    public static void getAll(@NotNull Context context) {
        try {
            context.json(dao.queryForAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getOne(@NotNull Context context, @NotNull String s) {
        long flowerId = Long.valueOf(s);
        try {
            Shop shop = dao.queryForId(flowerId);
            if (shop != null) {
                context.json(shop);
            } else {
                context.status(Constants.NOT_FOUND_404);
            }
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    static {
        logger = LoggerFactory.getLogger(FlowerController.class);
        try {
            dao = DaoManager.createDao(DatabaseUtils.getSourse(), Shop.class);
        } catch (SQLException e) {
            logger.error("Error creating DAO");
        }
    }
}
