import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1. Create some products
        Product p1 = new Product("Laptop", 1000, 5, 2.5, true, false);
        Product p2 = new Product("Book", 30, 10, 0.5, false, false);
        Product p3 = new Product("Headphones", 150, 3, 0.3, true, false);

        // 2. Add products to inventory
        Inventory inventory = new Inventory();
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        // 3. Create a customer with $2000 balance
        Customer customer = new Customer("Youssef", "youssef@example.com", 2000, "Cairo");

        // 4. Customer adds items to the cart
        customer.getCart().addItem(p1, 1); // 1 laptop
        customer.getCart().addItem(p2, 2); // 2 books
        customer.getCart().addItem(p3, 1); // 1 headphone

        // 5. Show subtotal and shipping cost
        System.out.println("Cart subtotal: $" + customer.getCart().getTotalPrice());
        System.out.println("Shipping fees: $" + customer.getCart().getShippingFees());

        // 6. Checkout
        customer.checkout();

        // 7. Show remaining balance
        System.out.println("Customer balance after purchase: $" + customer.getBalance());

        // 8. Ship products (only those that require shipping)
        ShippingService shippingService = new ShippingService();
        shippingService.shipItems(Arrays.asList(p1, p2, p3));

        // 9. Show updated inventory after purchase
        System.out.println("Inventory after purchase:");
        for (Product p : inventory.getAll()) {
            System.out.println(p);
        }
    }
}
