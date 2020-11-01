import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(name = "AddServlet", urlPatterns = "/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = (String) req.getParameter("a");
        String b = (String) req.getParameter("b");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<body>");
        out.println("<html>");

        try {
            int aint = Integer.parseInt(a);
            int bint = Integer.parseInt(b);
            req.setAttribute("a", aint);
            req.setAttribute("b", bint);
            RequestDispatcher rd = req.getRequestDispatcher("/doneServlet");
            rd.forward(req, resp);
        }
        catch (Exception e) {
            out.println("<h1>Wrong Parameter</h1>");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

//    public static boolean isNumeric(final String str) {
//        // null or empty
//        if (str == null || str.length() == 0) {
//            return false;
//        }
//        return str.chars().allMatch(Character::isDigit);
//    }
}
