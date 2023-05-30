package servlets;

import model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerProduct")
public class ProductRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // collect all form data
        String product_name = request.getParameter("product_name");
        String product_valueParam = request.getParameter("product_value");
        String category_idParam = request.getParameter("category_id");


        // parse parameter values
        Float product_value = null;
        Integer category_id = null;
        try {
            product_value = Float.parseFloat(product_valueParam.trim());
            category_id = Integer.valueOf(category_idParam.trim());
        } catch (NumberFormatException e) {
            throw new ServletException("Invalid parameter format", e);
        }

        // fill it up in a User bean
        Product product = new Product();

        // call Repository layer and save the user object to DB
        model.repository.Repository<Product> repository = new model.repository.ProductRepositoryImpl();
        int rows = 0;
        try {
            rows = repository.saveObj(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // prepare an information message for the user about the success or failure of the operation
        String infoMessage = null;
        if (rows == 0) {
            // infoMessage = "Ocurrio un error!"
            System.out.println("Ocurrio un error!");
        } else {
            // infoMessage = "Registro exitoso!"
            System.out.println("Registro exitoso!");
        }

        // todo write the message back to the page in the client browser
    }
}
