import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "route")
public class RouteEntity implements Serializable{

    @Id
    @Column
    private int route_id;

    @Column
    private String name;

    @Column
    private int length;

    @Column
    private int passenger_traffic;

    public int getRoute_id()
    {
        return route_id;
    }

    public void setRoute_id(int ticket_id)
    {
        this.route_id = ticket_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public int getPassenger_traffic()
    {
        return passenger_traffic;
    }

    public void setPassenger_traffic(int passenger_traffic)
    {
        this.passenger_traffic = passenger_traffic;
    }


    @Override
    public String toString(){
        return "Route {" +
                " route_id = " + route_id +
                " name = " + name +
                " length = " + length +
                " passenger_traffic = " + passenger_traffic +
                " }";
    }
}
