public class Table {
    private int Id;
    private int chairs;
    private Order order;


    //constructor
    public Table(int id, int chair){
        Id = id;
        chairs = chair;

    }
    public void addOrder(Order tempOrder){
    order = tempOrder;
    }
    public Order getOrder(){
        return order;
    }

}
