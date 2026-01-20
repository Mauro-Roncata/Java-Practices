import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import javax.swing.text.DateFormatter;

void main() throws ParseException {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("Enter client data: ");
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Birth date: ");
    Date birthDate = sdf.parse(sc.nextLine());

    Client c1 = new Client(name,email,birthDate);


    System.out.println("Enter order data: ");
    System.out.print("Status: ");
    String status = sc.nextLine();
    Order o1 = new Order(OrderStatus.valueOf(status), new Date(), c1);

    System.out.print("How many items to this order? ");
    int n = sc.nextInt();
    for (int i = 1; i<=n; i++){
        System.out.println("Enter #" + i + " item data:");
        System.out.print("Product name: ");
        String pName = sc.next();
        System.out.print("Product price: ");
        double pPrice = sc.nextDouble();

        Product product = new Product(pName, pPrice);

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        OrderItem o = new OrderItem(product,pPrice,quantity);
        o1.addItem(o);
    }

    System.out.println();
    System.out.println("ORDER SUMMARY: ");
    System.out.println(o1);

    sc.close();






}
