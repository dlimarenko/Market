import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
/**
 * @author Dmytro Limarenko
 */
@WebServlet(urlPatterns = "/FinalBasketServlet")
public class FinalBasketServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (BasketRepository.getBasket() == null){
            out.println("<h3>Нет продуктов в корзине</h3>");
        }else{
            double totalPrice = 0.;
            for (Map.Entry entry:BasketRepository.getBasket().getBasketMap().entrySet()) {
                Product product = (Product) entry.getValue();
                if (product.isKgBool()){
                    out.println("<h3>Имя продукта: " + product.getName() + "</h3>" + " кг: " + product.getKg() + "<br> цена: " + product.getFinalPrice());
                }else {
                    out.println("<h3>Имя продукта: " + product.getName() + "</h3>" + " количество: " + product.getCounter() + "<br> цена: " + product.getFinalPrice());
                }
                totalPrice = totalPrice + product.getFinalPrice();
            }
            out.println("<h3>Общая цена: " + totalPrice + "</h3>");
            BasketRepository.nullBasket();
        }
    }
}
