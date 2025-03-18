import java.util.Random;

public class billItems {
    Product product;
    double discount,total,quantity;

    public billItems(Product product, double quantity){
        Random random = new Random();
        this.product = product;
        this.quantity = quantity;
        this.discount = random.nextDouble(0,25);
        this.total = (product.price * quantity ) * (1-discount/100);
        product.quantity -= quantity;
    }
}
