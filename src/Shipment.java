import java.util.ArrayList;

public class Shipment {
    private String type;
    private double cost;
    private int days;



    public Shipment(String type, double cost, int days) {
        this.type = type;
        this.cost = cost;
        this.days = days;
    }

    public String getType() {
        return type;
    }

    public double getCost() {

        return cost;
    }

    public int getDays() {
        return days;
    }




}
