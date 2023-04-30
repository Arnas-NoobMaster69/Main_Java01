class LoyalUser extends User {
    private Double cashback;

    public LoyalUser(Integer id, String name, String surname, Double balance) {
        super(id, name, surname, balance);
        this.cashback = 0.05;
    }


    public void computeBalanceAfterOrder(Order order, Double ar) {
        Product product = SalesManagement.getProductByName(order.getProductName());
        User user = SalesManagement.getUserById(order.getUserId());
        double b= user.getBalance();
        b = ((b-(product.getPrice()* order.getQuantity()))-ar) + (product.getPrice() * cashback * order.getQuantity());

        balance = b;
    }

    private void setBalance(double v) {
    }
}
