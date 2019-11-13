import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Table {
    private int id;
    private int seats;
    private Order order;
    private String status;


    //constructor
    public Table(int Id, int Seats, String reserved) {
        id = Id;
        seats = Seats;
        status = reserved;

    }

    public Table getTable(){
        return this;
    }

    public int getSeats() {
        return seats;
    }
    public String getStatus(){
        return status;
    }

    public int getId() {
        return id;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
    public void setSeats(int newSeats){
        this.seats = newSeats;
    }
    public void setStatus(){

        this.status = "yes";
    }


    public Order getOrder() {
        return order;
    }
}
//made a change here