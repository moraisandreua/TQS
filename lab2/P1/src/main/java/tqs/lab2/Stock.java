package tqs.lab2;

public class Stock {
    private String name;
    private Integer quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Stock(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
