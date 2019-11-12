public class Food {
    String name;
    double price;
    String type;
    public Food(String name1, double price1, String type1){
        name = name1;
        price = price1;
        type = type1;

    }
    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }
}
