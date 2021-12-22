import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;


@Entity
@Table (name = "model")
public class ModelEntity implements Serializable{

    @Id
    @Column
    private int model_id;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private int capacity;

    public int getModel_id()
    {
        return model_id;
    }

    public void setModel_id(int model_id)
    {
        this.model_id = model_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }


    @Override
    public String toString(){
        return "Model {" +
                " model_id = " + model_id +
                " name = " + name +
                " category = " + category +
                " capacity = " + capacity +
                " }";
    }

}
