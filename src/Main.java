import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("Select an option:");
            System.out.println("1 - Add product");
            System.out.println("2 - Add user");
            System.out.println("3 - Add order");
            System.out.println("4 - All products");
            System.out.println("5 - All users");
            System.out.println("6 - All orders");
            System.out.println("7 - Detailed information about a product");
            System.out.println("8 - Detailed information about a user");
            System.out.println("9 - Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter product name:");
                    String productName = scanner.nextLine();
                    System.out.println("Enter product quantity:");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter product price:");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine();
                    SalesManagement.addProduct(new Product(SalesManagement.getProducts().size() + 1, productName, productQuantity, productPrice));
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    System.out.println("Enter user type (1 for OrdinaryUser, 2 for PrimeUser, 3 for LoyalUser):");
                    int userType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter user name:");
                    String userName = scanner.nextLine();
                    System.out.println("Enter user surname:");
                    String userSurname = scanner.nextLine();
                    System.out.println("Enter user balance:");
                    double userBalance = scanner.nextDouble();
                    scanner.nextLine();
                    switch (userType) {
                        case 1:
                            SalesManagement.addUser(new OrdinaryUser(SalesManagement.getUsers().size() + 1, userName, userSurname, userBalance));
                            break;
                        case 2:
                            SalesManagement.addUser(new PrimeUser(SalesManagement.getUsers().size() + 1, userName, userSurname, userBalance));
                            break;
                        case 3:
                            SalesManagement.addUser(new LoyalUser(SalesManagement.getUsers().size() + 1, userName, userSurname, userBalance));
                            break;
                        default:
                            System.out.println("Invalid user type!");
                            break;
                    }
                    System.out.println("User added successfully!");
                    break;
                case 3:
                    System.out.println("User ID:");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Product name:");
                    String orderProductName = scanner.nextLine();
                    System.out.println("Order quantity:");
                    int orderQuantity = scanner.nextInt();
                    scanner.nextLine();
                    Order order1 = new Order(userId, orderProductName, orderQuantity);

                    Product product1 = SalesManagement.getProductByName(order1.getProductName());
                    double price = product1.getPrice() * orderQuantity;



                    System.out.println("Enter shipment type (1 for Regular, 2 for Express, 3 for SuperExpress):");
                    int shiptype = scanner.nextInt();
                double cost = 0;

                    switch (shiptype) {
                        case 1:
                            cost=0;
                            Shipment myShipment = new Shipment("Regular", cost, 7);
                            SalesManagement.addShipment( myShipment);


                            break;
                        case 2:
                            cost = price*0.05;
                            Shipment myShipment2 = new Shipment("Express", cost, 3);
                            SalesManagement.addShipment( myShipment2);
                            break;
                        case 3:
                            cost = price*0.08;
                            Shipment myShipment3 = new Shipment("SuperExpress", cost, 1);
                            SalesManagement.addShipment( myShipment3);
                            break;
                        default:
                            System.out.println("Invalid user type!");
                            break;
                    }
                    SalesManagement.addOrder(order1, cost);

                    System.out.println( "Shipment price: "+ cost);




                    System.out.println("Order added successfully!");

                    break;
                case 4:
                    ArrayList<Product> products = SalesManagement.getProducts();
                    System.out.println("List of all products:");
                    for (Product product : products) {
                        System.out.println("- " + product.getName() + " (ID: " + product.getId() + ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice() + ")");
                    }

                    ArrayList<Shipment> shipments = SalesManagement.getShipments();
                    for(Shipment shipment : shipments){
                        System.out.println("- " + shipment.getType() + " (Cost: " + shipment.getCost() + ", Days: " + shipment.getDays()+ ")");

                    }
                    break;
                case 5:
                    ArrayList<User> users = SalesManagement.getUsers();
                    System.out.println("List of all users:");
                    for (User user : users) {
                        System.out.println("- " + user.getName() + " " + user.getSurname() + " (ID: " + user.getId() + ", Balance: " + user.getBalance() + ")");
                    }
                    break;
                case 6:
                    ArrayList<Order> orders = SalesManagement.getOrders();
                    System.out.println("List of all orders:");
                    for (Order order : orders) {
                        System.out.println("- User " + order.getUserId() + " ordered " + order.getQuantity() + " " + order.getProductName() + "(s)");
                    }
                    break;
                case 7:
                    System.out.println("Enter product name:");
                    String detailedProductName = scanner.nextLine();
                    Product detailedProduct = SalesManagement.getProductByName(detailedProductName);
                    if (detailedProduct != null) {
                        System.out.println("Product details:");
                        System.out.println("- ID: " + detailedProduct.getId());
                        System.out.println("- Name: " + detailedProduct.getName());
                        System.out.println("- Quantity: " + detailedProduct.getQuantity());
                        System.out.println("- Price: " + detailedProduct.getPrice());
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case 8:
                    System.out.println("Enter user ID:");
                    int detailedUserId = scanner.nextInt();
                    scanner.nextLine();
                    User detailedUser = SalesManagement.getUserById(detailedUserId);
                    if (detailedUser != null) {
                        System.out.println("User details:");
                        System.out.println("- Name: " + detailedUser.getName());
                        System.out.println("- Surname: " + detailedUser.getSurname());
                        System.out.println("- Balance: " + detailedUser.getBalance());
                        if (detailedUser instanceof PrimeUser) {
                            System.out.println("- User is a prime user");
                        }
                        if (detailedUser instanceof LoyalUser) {
                            System.out.println("- User is a loyal user");
                        }
                    } else {
                        System.out.println("User not found!");
                    }
                    break;
                case 9:
                    running = false;
                    System.out.println("Good by");
                    break;
                default:
                    System.out.println("Invalid option Error");
                    break;
            }
        }

        scanner.close();
    }
}


