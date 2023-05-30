package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import model.repository.Repository;
import model.repository.UserRepositoryImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerUser")
public class UserRegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {super.doPost(request, response);

         // collect all form data

        String user_firstname= request.getParameter("user_firstname");
        String user_lastname= request.getParameter("user_lastname");
        String user_email= request.getParameter("user_email");
        String user_password= request.getParameter("user_password");

        //  fill it up´in a User bean

        User user = new User(user_firstname, user_lastname, user_email, user_password);

        //  call Repository layer and save the user object to DB

        Repository<User> repository=new UserRepositoryImpl();
        int rows;
        try {
           rows = repository.saveObj(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // prepare an information message for user about success or failure of the operation

        String infoMessage = null;

        if (rows == 0) {
            //infoMessage = "Ocurrió un error!"
            System.out.println("Ocurrió un error!");
        } else {
            // infoMessage = "Registro exitoso!"
            System.out.println("Registro exitoso!");
        }

        // todo write the message back to the page in client browser
    }
}


//Servlet para User, Category, Product

    // Category -> Campos
    // * category_id
    // * category_name
//--------------------------------------------------------------------------------------
    // Product -> Campos
    // * product_id
    // * product_name
    // * product_value
    // * category_id -> Llave foranea

// Create objet Bean, ObjRepositoryImp, S<ervlet

// vista -> JSP -> Formularies for category and product