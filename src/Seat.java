public class Seat {
    private int id;
    private Table relatedTable;
    private Order relatedOrder;

    public Seat(Table table, Order order){
        relatedTable = table;
        relatedOrder = order;


    }

    public Order getRelatedOrder() {
        return relatedOrder;
    }

}
