import com.mysql.cj.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductUtil {

    private ProductUtil() {}

    public static void createTable() {

        String createSql = "CREATE TABLE PRODUCTS (" +
                "ID INTEGER NOT NULL AUTO_INCREMENT," +
                "PRODUCT_NAME VARCHAR(255)," +
                "PRICE DOUBLE NOT NULL," +
                "QUANTITY INTEGER NOT NULL," +
                "PRIMARY KEY(ID))";

        try {
            JDBCUtil.getStatement().executeUpdate(createSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Created table in given database...");
    }

    public static void insert(Product product) {

        String insertSql = "INSERT INTO PRODUCTS(PRODUCT_NAME, PRICE, QUANTITY) VALUES(" +
                "'"+ product.getName() + "', " +
                "'"+ product.getPrice() + "', " +
                ""+ product.getQuantity() + ")";

        try {
            JDBCUtil.getStatement().executeUpdate(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inserted...");
    }

    public static void getSameProduct() {

        String selectSql = "SELECT PRODUCT_NAME, COUNT(*) FROM PRODUCTS GROUP BY PRODUCT_NAME";

        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                String productName = resultSet.getString("PRODUCT_NAME");
                int count = resultSet.getInt(2);
                System.out.println(productName + " = " + count);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> getAllProducts() {

        String selectSql = "SELECT * FROM PRODUCTS";

        List<Product> products = new ArrayList<>();

        try {
            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getString("PRODUCT_NAME"),
                        resultSet.getInt(4)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public static void updateProduct(long id, double newProductPrice) {

        String updateSql = "UPDATE PRODUCTS SET PRICE = '"+ newProductPrice +"' WHERE ID = " + id;

        try {
            JDBCUtil.getStatement().executeUpdate(updateSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Updated...");
    }

    public static void deleteProduct(long id) {

        String deleteSql = "DELETE FROM PRODUCTS WHERE ID = " + id;

        try {
            JDBCUtil.getStatement().executeUpdate(deleteSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Deleted...");
    }
}
