public class Product {

    private Long id;
    private String productName;
    private Double price;
    private Integer quantity;

    public Product() {
    }

    public Product(Long id, String productName, Double price, Integer quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String productName, Double price, Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String productName, Integer quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
