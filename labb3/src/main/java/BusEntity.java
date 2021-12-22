import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;


@Entity
@Table (name = "bus")
public class BusEntity implements Serializable{

    @Id
    @Column
    private int bus_id;

    @Column
    private int model_id;

    @Column
    private int route_id;

    public int getBus_id()
    {
        return bus_id;
    }

    public void setBus_id(int bus_id)
    {
        this.bus_id = bus_id;
    }

    public int getModel_id()
    {
        return model_id;
    }

    public void setModel_id(int model_id)
    {
        this.model_id = model_id;
    }

    public int getRoute_id()
    {
        return route_id;
    }

    public void setRoute_id(int route_id)
    {
        this.route_id = route_id;
    }


    @Override
    public String toString(){
        return "Bus {" +
                " bus_id = " + bus_id +
                " model_id = " + model_id +
                " route_id = " + route_id +
                " }";
    }
}
