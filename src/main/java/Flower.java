import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "flowers")
public class Flower {
    @DatabaseField(generatedId = true)
    private long flowerId;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField(canBeNull = false)
    private long coast;

    @DatabaseField
    private long width;

    @DatabaseField
    private long heigh;

    public Flower(){
    }

    public long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(long flowerId) {
        this.flowerId = flowerId;
    }

    public long getHeigh() {
        return heigh;
    }

    public void setHeigh(long heigh) {
        this.heigh = heigh;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getCoast() {
        return coast;
    }

    public void setCoast(long coast) {
        this.coast = coast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
