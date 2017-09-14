/**
 * @author Dmytro Limarenko
 */
public class Order {

    private String name;
    private double kg;

    public Order(String name, double kg) {
        this.name = name;
        this.kg = kg;
    }

    public Order(String name) {
        this.name = name;
        this.kg = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
}