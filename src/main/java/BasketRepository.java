/**
 * @author Dmytro Limarenko
 */
public final class BasketRepository {
    private static Basket basket = null;

    public BasketRepository() {
    }

    public static Basket getBasket() {
        return basket;
    }

    public static void setBasket(Basket basket) {
        BasketRepository.basket = basket;
    }

    public static void newBasket(){
        basket = new Basket();
    }

    public static void nullBasket(){
        basket = null;
    }
    public static void  addOrder(Order order){
        basket.addOrder(order);
    }

    public static void recalculationBasket(String name){
        basket.recalculationBasket(name);
    }

    public static double finalPrice(){
        return basket.finalPrice();
    }
}
