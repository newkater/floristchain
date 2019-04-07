package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "shop-flower-country")
public class ShopFlowerCountry {
    @DatabaseField
    private long shopId;

    @DatabaseField
    private long flowerId;

    @DatabaseField
    private long countryId;

    public ShopFlowerCountry() {
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(long flowerId) {
        this.flowerId = flowerId;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }
}
