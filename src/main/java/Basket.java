import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmytro Limarenko
 */
public class Basket {

    private HashMap<String,Product> basketMap;
    private HashMap<String,Product> saleMap;

    public Basket() {
        this.basketMap  = new HashMap<String, Product>();
        this.saleMap = new HashMap<String, Product>();
    }

    public void addOrder(Order order){
        if (basketMap.get(order.getName())!= null){
            if (basketMap.get(order.getName()).isKgBool()){
                basketMap.get(order.getName()).addKilo(order.getKg());
                recalculationBasket(order.getName());
            }else {
                basketMap.get(order.getName()).addCounter();
                recalculationBasket(order.getName());
                System.out.println(order.getKg());
            }
        }else {
            if(saleMap.get(order.getName())!= null){
                basketMap.put(order.getName(),saleMap.get(order.getName()));
                saleMap.remove(order.getName());
            }else {
                basketMap.put(order.getName(), new Product(order));
                recalculationBasket(order.getName());
            }
        }
    }

    public void recalculationBasket(String name){

        Product productTemp = basketMap.get(name);
        if (productTemp.getSaleAmount() != 0 && productTemp.getSaleAmount()<=productTemp.getCounter()){
            if (productTemp.getSalePrice() != 0){
                productTemp.setFinalPrice(productTemp.getCounter()/productTemp.getSaleAmount()
                        *productTemp.getSalePrice()+(productTemp.getCounter()
                        %productTemp.getSaleAmount())*productTemp.getPrice()-productTemp.getSale());
            }
            String free = productTemp.getFree();
            if (productTemp.getFree() != null){
                productTemp.setFinalPrice(productTemp.getCounter()*productTemp.getPrice()-productTemp.getSale());
                Product productForSale = basketMap.get(free);
                if (productForSale != null) {
                    productForSale.setSale(productTemp.getCounter() / productTemp.getSaleAmount() * productForSale.getPrice());
                    productForSale.setFinalPrice(productForSale.getCounter() * productForSale.getPrice() - productForSale.getSale());
                } else {
                    saleMap.put(free,new Product(productTemp.getFree()));
                    productForSale = saleMap.get(free);
                    productForSale.setSale(productTemp.getCounter() / productTemp.getSaleAmount() * productForSale.getPrice());
                    productForSale.setFinalPrice(productForSale.getCounter() * productForSale.getPrice() - productForSale.getSale());
                }
            }
        }else {
                productTemp.setFinalPrice(productTemp.getCounter() * productTemp.getPrice() - productTemp.getSale());
        }
    }

    public double finalPrice(){
        double finalPrice = 0;
        for (Map.Entry entry :basketMap.entrySet()) {
            Product product = (Product) entry.getValue();
            finalPrice = finalPrice + product.getFinalPrice();
        }
        return finalPrice;
    }

    public HashMap<String, Product> getBasketMap() {
        return basketMap;
    }

    public HashMap<String, Product> getSaleMap() {
        return saleMap;
    }
}