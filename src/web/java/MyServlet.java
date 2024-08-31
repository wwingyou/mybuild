import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {

    @Override
    public void doGet(
            HttpServletRequest request, 
            HttpServletResponse response
    ) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.println("Hello");
    }
}
