import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        ProductUtil.createTable();
//        ProductUtil.insert(new Product("Potato", 2.30, 1));
//        ProductUtil.insert(new Product("Potato", 2.35, 56));
//        ProductUtil.insert(new Product("Tomato", 4.5, 23));
//        ProductUtil.insert(new Product("Tomato", 6.7, 32));
//        ProductUtil.insert(new Product("Tomato", 2.0, 1));
//        ProductUtil.insert(new Product("Pizza", 14.0, 2));
//        ProductUtil.insert(new Product("Pizza", 15.6, 5));
//        ProductUtil.insert(new Product("Pizza", 11.3, 3));
//        ProductUtil.insert(new Product("Pizza", 145.6, 78));
//        ProductUtil.getSameProduct();
//        ProductUtil.updateProduct(2, 666.666);
//        ProductUtil.deleteProduct(2);
        System.out.println(ProductUtil.getAllProducts()
                .stream()
                .collect(Collectors.toMap(Product::getName, Product::getQuantity, (q1, q2) -> q1+q2)));
    }
}