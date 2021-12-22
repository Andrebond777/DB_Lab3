import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "driver")
public class DriverEntity implements Serializable{

    @Id
    @Column
    private int driver_id;

    @Column
    private int bus_id;

    @Column
    private String full_name;

    @Column
    private int allowed_categories;

    @Column
    private int working_hours;

    public int getDriver_id()
    {
        return driver_id;
    }

    public void setDriver_id(int ticket_id)
    {
        this.driver_id = ticket_id;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public String getFull_name()
    {
        return full_name;
    }

    public void setFull_name(String full_name)
    {
        this.full_name = full_name;
    }

    public int getAllowed_categories()
    {
        return allowed_categories;
    }

    public void setAllowed_categories(int passenger_traffic)
    {
        this.allowed_categories = passenger_traffic;
    }

    public int getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(int working_hours) {
        this.working_hours = working_hours;
    }


    @Override
    public String toString(){
        return "Driver {" +
                " driver_id = " + driver_id +
                " bus_id = " + bus_id +
                " full_name = " + full_name +
                " allowed_categories = " + allowed_categories +
                " working_hours = " + working_hours +
                " }";
    }
}
