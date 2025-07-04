public class Product implements Shippable{
    String name;
    double price;
    int quantity;
    double weight;
    private boolean requiresShipping;
    private boolean expired;

    public Product(String name, double price, int quantity, double weight, boolean requiresShipping, boolean expired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.requiresShipping = requiresShipping;
        this.expired = expired;
    }

    public boolean requiresShipping() {
        return requiresShipping;
    }

    public boolean isExpired() {
        return expired;
    }

    public String getName() {return name;}
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {return price;}
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (" + quantity + " in stock)"
                + ", Requires Shipping: " + requiresShipping
                + ", Expired: " + expired;
    }

    public void reduceQuantity(int amount) {
        if (amount <= quantity) {
            this.quantity -= amount;
        } else{
            throw new IllegalArgumentException("Not enough stock");
        }
    }

    public void increaseQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        } else {
            System.out.println("Amount must be positive");
        }
    }
}
