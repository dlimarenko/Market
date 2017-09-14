import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author Dmytro Limarenko
 */
@WebServlet(urlPatterns = "/AddToBasketServlet")
public class AddToBasketServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("product");
        String inputKgString = (request.getParameter("inputKg"));
        Double inputKg;
        if (inputKgString.isEmpty()){
            inputKg = 0.;
        }else {
            inputKg = Double.valueOf(inputKgString);
        }
        Order orderName;

        if (inputKg == 0){
            orderName = new Order(name);
        }else {
            orderName = new Order(name, inputKg);
        }
            if (BasketRepository.getBasket() == null) {
                BasketRepository.newBasket();
                BasketRepository.addOrder(orderName);
            } else {
                BasketRepository.addOrder(orderName);
            }
            response.sendRedirect("http://localhost:8080/index");
    }
}