import java.util.List;

public class ShippingService {

    public void shipItems(List<Product> products) {
        boolean hasItemsToShip = false;

        System.out.println("----- Shipping Summary -----");
        for (Product product : products) {
            if (product.requiresShipping()) {
                hasItemsToShip = true;
                System.out.println("Shipping: " + product.getName() + " - Weight: " + product.getWeight() + "kg");
            }
        }

        if (!hasItemsToShip) {
            System.out.println("No items to ship.");
        } else {
            System.out.println("Shipping complete ✅");
        }
    }
}
