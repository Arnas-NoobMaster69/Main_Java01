import java.util.ArrayList;

class SalesManagement {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Shipment> shipments = new ArrayList<>();

    public static void addOrder(Order order, Double ar) {


        Product product = getProductByName(order.getProductName());

        User user = getUserById(order.getUserId());

        if (user != null && product != null && product.getQuantity() >= order.getQuantity() && user.getBalance() >= product.getPrice() * order.getQuantity()) {
            user.getOrderHistory().add(order);
            product.setQuantity(product.getQuantity() - order.getQuantity());
            if(product.getQuantity() == 0){
                System.out.println("Now the product is no more");
            }

            user.computeBalanceAfterOrder(order, ar);
            orders.add(order);
        }
    }
    public static void addUser(User user) {
        users.add(user);
    }

    public static Double getProductPrice(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product.getPrice();
            }
        }
        return -1.0;
    }

    public static Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static User getUserById(Integer userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void addProduct(Product product) { products.add(product);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addShipment(Shipment shipment) {shipments.add(shipment);}

    public static ArrayList<Shipment> getShipments() {return shipments;}




}
