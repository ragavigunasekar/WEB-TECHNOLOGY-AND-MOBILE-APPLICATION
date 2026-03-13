import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if(session != null && session.getAttribute("user") != null) {

            String user = (String) session.getAttribute("user");

            out.println("<h2>Welcome " + user + "</h2>");
            out.println("<a href='LogoutServlet'>Logout</a>");

        } else {

            response.sendRedirect("login.html");

        }
    }
}