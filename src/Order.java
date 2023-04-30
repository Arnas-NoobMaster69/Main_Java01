class Order {
    private Integer quantity;
    private Integer userId;
    private String productName;




    public Order(Integer userId, String productName, Integer quantity) {
        this.quantity = quantity;
        this.userId = userId;
        this.productName = productName;

    }


    public String getProductName() {
        return productName;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

