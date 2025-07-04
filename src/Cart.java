import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(Product product) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().equals(product)) {
                items.remove(i);
                System.out.println("Removed product " + product.getName() + " from cart");
                break;
            }
        }
    }

    public void reduceQuantity(Product product, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.getProduct().equals(product)) {
                int newQty = item.getQuantity() - quantity;
                if (newQty <= 0) {
                    items.remove(i);
                    System.out.println("Removed product " + product.getName() + " from cart");
                } else {
                    item.setQuantity(newQty);
                    System.out.println("Reduced quantity of " + product.getName() + " to " + newQty);
                }
                break;
            }
        }
    }

    public void increaseQuantity(Product product, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().equals(product)) {
                items.get(i).setQuantity(items.get(i).getQuantity() + quantity);
                System.out.println("Increased quantity to " + product.getName());
                break;
            }
        }
    }

    public void removeAll() {
        items.clear();
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getShippingFees() {
        double subtotalForShipping = 0;
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p.requiresShipping()) {
                subtotalForShipping += p.getPrice() * item.getQuantity();
            }
        }
        return subtotalForShipping * 0.10;
    }


    public void checkout() {
        if (items.size() == 0) {
            System.out.println("No items in your cart");
            return;
        }

        System.out.println("----- Checkout Summary -----");

        for(CartItem item : items) {
            Product p = item.getProduct();
            int quantity = item.getQuantity();

            if (quantity > p.getQuantity()) {
                System.out.println("Not enough stock for: " + p.getName());
                return;
            }
        }

        for(CartItem item : items) {
            Product p = item.getProduct();
            int quantity = item.getQuantity();
            p.setQuantity(p.getQuantity() - quantity);
            System.out.println(p.getName() + " x" + quantity + " = $" + item.getTotalPrice());
        }

        double subtotal = getTotalPrice();
        double shipping = getShippingFees();
        double total = subtotal + shipping;

        System.out.println("Order subtotal: $" + subtotal);
        System.out.println("Shipping fees: $" + shipping);
        System.out.println("Paid amount: $" + total);
        items.clear();
        System.out.println("--------------------------------------------------");
        System.out.println("Checkout complete! Thank you for your purchase.");
    }


}
