public class Customer {
    private String name;
    private String email;
    private Cart cart;
    private double Balance;
    private String shippingAddress;

    public Customer(String name, String email, double balance,  String shippingAddress) {
        this.name = name;
        this.email = email;
        this.Balance = balance;
        this.shippingAddress = shippingAddress;
        this.cart = new Cart();
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public double getBalance() {return Balance;}
    public String getShippingAddress() {return shippingAddress;}
    public Cart getCart() {return cart;}


    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setShippingAddress(String shippingAddress) {this.shippingAddress = shippingAddress;}
    public void setBalance(double balance) {this.Balance = balance;}

    public void increaseBalance(double balance) {
        this.Balance += balance;
    }

    public void checkout() {
        System.out.println("Checking out");
        double subtotal = cart.getTotalPrice();
        double shipping = cart.getShippingFees();
        double total = subtotal + shipping;

        if (total > this.getBalance()) {
            System.out.println("❌ Not enough balance. You need $" + total + " but you have $" + this.getBalance());
        } else {
            this.setBalance(this.getBalance() - total);
            cart.checkout();
            System.out.println("✅ Purchase completed. Remaining balance: $" + this.getBalance());
        }
    }

    @Override
    public String toString() {
        return "Customer: " + name + " (" + email + "), Balance: $" + this.getBalance();
    }

}
