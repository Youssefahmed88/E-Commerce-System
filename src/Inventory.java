import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findByName(String name){
        for (Product p : products) {
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }

    public void  reStock(String name, int amount) {
        Product p = findByName(name);
        if(p != null){
            p.increaseQuantity(amount);
        } else {
            System.out.println("Product not found");
        }
    }

    public List<Product> getAll() {
        return products;
    }

}
