package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "cities")
public class City {
    @DatabaseField(generatedId = true)
    private long cityId;

    @DatabaseField
    private String name;

    @DatabaseField
    private long countryId;
}
