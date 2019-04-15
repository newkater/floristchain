package controller;

import configuration.Constants;
import io.javalin.Context;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import configuration.DatabaseUtils;
import io.javalin.Javalin;
import model.Flower;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class FlowerController {
    private static Dao<Flower, Long> dao;
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
            Flower flower = dao.queryForId(flowerId);
            if (flower != null) {
                context.json(flower);
            } else {
                context.status(Constants.NOT_FOUND_404);
            }
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public static void create(@NotNull Context context) {
        Flower flower = context.bodyAsClass(Flower.class);
        try {
            dao.create(flower);
            context.status(Constants.CREATED_201);
        } catch (SQLException e) {
            logger.error("Error occurred saving record");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public static void delete(@NotNull Context context, @NotNull String s) {
        long flowerId = Long.valueOf(s);
        try {
            dao.deleteById(flowerId);
        } catch (SQLException e) {
            logger.error("Error occurred deleting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public static void update(@NotNull Context context, @NotNull String s) {
        long flowerId = Long.valueOf(s);
        Flower newFlower = context.bodyAsClass(Flower.class);
        newFlower.setFlowerId(flowerId);
        try {
            dao.update(newFlower);
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    static {
        logger = LoggerFactory.getLogger(FlowerController.class);
        try {
            dao = DaoManager.createDao(DatabaseUtils.getSourse(), Flower.class);
        } catch (SQLException e) {
            logger.error("Error creating DAO");
        }
    }
}
