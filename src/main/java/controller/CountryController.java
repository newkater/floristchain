package controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import configuration.Constants;
import configuration.DatabaseUtils;
import io.javalin.Context;
import model.Country;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class CountryController {
    private static Dao<Country, Long> dao;
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
            Country country = dao.queryForId(flowerId);
            if (country != null) {
                context.json(country);
            } else {
                context.status(Constants.NOT_FOUND_404);
            }
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public void create(@NotNull Context context) {
        Country country = context.bodyAsClass(Country.class);
        try {
            dao.create(country);
            context.status(Constants.CREATED_201);
        } catch (SQLException e) {
            logger.error("Error occurred saving record");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public void delete(@NotNull Context context, @NotNull String s) {
        long countryId = Long.valueOf(s);
        try {
            dao.deleteById(countryId);
        } catch (SQLException e) {
            logger.error("Error occurred deleting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    public void update(@NotNull Context context, @NotNull String s) {
        long countryId = Long.valueOf(s);
        Country newCountry = context.bodyAsClass(Country.class);
        newCountry.setCountryId(countryId);
        try {
            dao.update(newCountry);
        } catch (SQLException e) {
            logger.error("Error occurred getting records");
            context.status(Constants.INTERNAL_SERVER_ERROR_500);
        }
    }

    static {
        logger = LoggerFactory.getLogger(CountryController.class);
        try {
            dao = DaoManager.createDao(DatabaseUtils.getSourse(), Country.class);
        } catch (SQLException e) {
            logger.error("Error creating DAO");
        }
    }
}
