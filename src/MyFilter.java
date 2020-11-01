import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter", urlPatterns = {"/addServlet"})
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        HttpSession session = request.getSession();

        String a = req.getParameter("a");
        String b = req.getParameter("b");

        req.setAttribute("a", a);
        req.setAttribute("b", b);

        if(session.getAttribute("success") == null) {
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
