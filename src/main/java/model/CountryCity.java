package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "country-city")
public class CountryCity {
    @DatabaseField(generatedId = true)
    private long countryCityId;

    @DatabaseField
    private long countryId;

    @DatabaseField
    private long cityId;

    public CountryCity(){
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getCountryCityId() {
        return countryCityId;
    }

    public void setCountryCityId(long countryCityId) {
        this.countryCityId = countryCityId;
    }
}
