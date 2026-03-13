import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("1234")) {

            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            response.sendRedirect("DashboardServlet");

        } else {

            PrintWriter out = response.getWriter();
            out.println("<h3>Invalid Username or Password</h3>");
            out.println("<a href='login.html'>Try Again</a>");

        }
    }
}