class PrimeUser extends User {
    public PrimeUser(Integer id, String name, String surname, Double balance) {
        super(id, name, surname, balance);
    }


    public void computeBalanceAfterOrder(Order order, Double ar) {
        if (order.getQuantity() > 1) {
            Product product = SalesManagement.getProductByName(order.getProductName());
            User user = SalesManagement.getUserById(order.getUserId());
            double b= user.getBalance();
            b = ((b-(product.getPrice()* order.getQuantity()))-ar) + (product.getPrice()*0.05 * order.getQuantity());

            balance = b;
        }
        Product product = SalesManagement.getProductByName(order.getProductName());
        User user = SalesManagement.getUserById(order.getUserId());
        double b= user.getBalance();
        b = (b-(product.getPrice()* order.getQuantity()))-ar;

        balance = b;
    }

    public void setBalance(double v) {
    }
}
