import java.util.ArrayList;

class OrdinaryUser extends User {


    public OrdinaryUser(Integer id, String name, String surname, Double balance) {

        super(id, name, surname, balance);
    }


    public void computeBalanceAfterOrder(Order order, Double ar) {

        Product product = SalesManagement.getProductByName(order.getProductName());
        User user = SalesManagement.getUserById(order.getUserId());
       double b= user.getBalance();
        b = (b-(product.getPrice()* order.getQuantity()))-ar;

       balance = b;
    }




}
