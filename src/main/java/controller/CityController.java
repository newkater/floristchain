package controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import configuration.Constants;
import configuration.DatabaseUtils;
import io.javalin.Context;
import model.City;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class CityController {
    private static Dao<City, Long> dao;
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
            City city = dao.queryForId(flowerId);
            if (city != null) {
                context.json(city);
            } else {
                context.status(Constants.NOT_FOUND_404);
            }
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public static void create(@NotNull Context context) {
        City city = context.bodyAsClass(City.class);
        try {
            dao.create(city);
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
        long cityId = Long.valueOf(s);
        City newCity = context.bodyAsClass(City.class);
        newCity.setCityId(cityId);
        try {
            dao.update(newCity);
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    static {
        logger = LoggerFactory.getLogger(CityController.class);
        try {
            dao = DaoManager.createDao(DatabaseUtils.getSourse(), City.class);
        } catch (SQLException e) {
            logger.error("Error creating DAO");
        }
    }
}
