import java.sql.*;
/**
 * @author Dmytro Limarenko
 */
public class Product {

    private static final String url = "jdbc:mysql://localhost:3306/products";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    private String name;
    private double price;
    private Integer counter;
    private Integer saleAmount;
    private Double salePrice;
    private boolean kgBool;
    private double kg;
    private double finalPrice;
    private String free;
    private double sale = 0;

    public Product(String name) {
        this.name = name;
        this.kg = 1;
        counter = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            String query = "SELECT * FROM products.products WHERE name='"+name+"'";
            rs = stmt.executeQuery(query);

            while (rs.next()){
                this.price = rs.getDouble("price");
                this.saleAmount = rs.getInt("saleAmount");
                this.salePrice = rs.getDouble("salePrice");
                this.kgBool = rs.getBoolean("kg_bool");
                this.free = rs.getString("free");
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                con.close(); } catch(SQLException se) {
            }
            try {
                stmt.close(); } catch(SQLException se) {
            }
            try {
                rs.close(); } catch(SQLException se) {
            }
        }
    }

    public Product(Order order) {
        this.name = order.getName();
        this.kg = order.getKg();
        counter = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            String query = "SELECT * FROM products.products WHERE name='"+name+"'";
            rs = stmt.executeQuery(query);

            while (rs.next()){
                this.price = rs.getDouble("price");
                this.saleAmount = rs.getInt("saleAmount");
                this.salePrice = rs.getDouble("salePrice");
                this.kgBool = rs.getBoolean("kg_bool");
                this.free = rs.getString("free");
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                con.close(); } catch(SQLException se) {
            }
            try {
                stmt.close(); } catch(SQLException se) {
            }
            try {
                rs.close(); } catch(SQLException se) {
            }
        }
    }

    public Product(String name, double kg) {
        this.name = name;
        this.kg = kg;
        counter = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            String query = "SELECT * FROM products.products WHERE name='"+name+"'";
            rs = stmt.executeQuery(query);

            while (rs.next()){
                this.price = rs.getDouble("price");
                this.saleAmount = rs.getInt("saleAmount");
                this.salePrice = rs.getDouble("salePrice");
                this.kgBool = rs.getBoolean("kg_bool");
                this.free = rs.getString("free");
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                con.close(); } catch(SQLException se) {
            }
            try {
                stmt.close(); } catch(SQLException se) {
            }
            try {
                rs.close(); } catch(SQLException se) {
            }
        }
    }



    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public String getFree() {
        return free;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCounter() {
        return counter;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public boolean isKgBool() {
        return kgBool;
    }

    public double getKg() {
        return kg;
    }

    public double getFinalPrice() {

        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice*kg;
    }

    public void addKilo(double newKilo){
        kg = kg + newKilo;
    }

    public void addCounter(){
        counter++;
    }
}
