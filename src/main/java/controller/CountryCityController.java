package controller;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import configuration.Constants;
import configuration.DatabaseUtils;
import io.javalin.Context;
import model.CountryCity;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class CountryCityController {
    private static Dao<CountryCity, Long> dao;
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
            CountryCity countryCity = dao.queryForId(flowerId);
            if (countryCity != null) {
                context.json(countryCity);
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
            dao = DaoManager.createDao(DatabaseUtils.getSourse(), CountryCity.class);
        } catch (SQLException e) {
            logger.error("Error creating DAO");
        }
    }
}
