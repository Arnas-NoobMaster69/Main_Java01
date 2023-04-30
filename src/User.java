import java.util.ArrayList;

public abstract class User {
    public Double balance;
    private ArrayList<Order> orderHistory;
    private Integer id;
    private String name;
    private String surname;


    public User(Integer id, String name, String surname, Double balance) {
        this.balance = balance;
        this.orderHistory = new ArrayList<>();
        this.id = id;
        this.name = name;
        this.surname = surname;

    }

    public String getSurname() {
        return surname;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public abstract void computeBalanceAfterOrder(Order order, Double ar);

}
