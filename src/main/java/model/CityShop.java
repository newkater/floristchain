package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "city-shop")
public class CityShop {
    @DatabaseField(generatedId = true)
    private long cityShopId;

    @DatabaseField
    private long cityId;

    @DatabaseField
    private long shopId;

    public CityShop() {
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getCityShopId() {
        return cityShopId;
    }

    public void setCityShopId(long cityShopId) {
        this.cityShopId = cityShopId;
    }
}
