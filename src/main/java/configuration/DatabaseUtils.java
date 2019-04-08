package configuration;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import exceptiions.InvalidConnectionSourseException;
import model.*;

import java.sql.SQLException;

public class DatabaseUtils {
    private static ConnectionSource sourse;
    static {
        try {
            sourse = new JdbcConnectionSource(Constants.DB_PATH);

            TableUtils.createTableIfNotExists(sourse, City.class);
            TableUtils.createTableIfNotExists(sourse, CityShop.class);
            TableUtils.createTableIfNotExists(sourse, Country.class);
            TableUtils.createTableIfNotExists(sourse, CountryCity.class);
            TableUtils.createTableIfNotExists(sourse, Flower.class);
            TableUtils.createTableIfNotExists(sourse, Shop.class);
            TableUtils.createTableIfNotExists(sourse, ShopFlowerCountry.class);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionSource getSourse()  {
        if (sourse == null) throw new InvalidConnectionSourseException();
        return sourse;
    }
}
