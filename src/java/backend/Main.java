package backend;

import data.CakeMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bottom;
import model.Toppings;
import model.User;

@WebServlet(urlPatterns
        = {
            "/Main"
        })
public class Main extends HttpServlet {

    CakeMapper cm = new CakeMapper();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LoginService loginService = new DummyLoginService();
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if ("login".equals(action)) {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            User user = loginService.login(cm.getUser(userID).getUserID(), cm.getUser(userID).getPassword(), cm.getUser(userID).getBalance());
            
            if (user == null) {
                //Login failed
                sendLoginForm(request, response);
                return;
            }
            request.getSession().setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("cupcake.jsp");
            rd.forward(request, response);
            return;
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            sendLoginForm(request, response);
            return;
        }
        if (action == null) {
            RequestDispatcher rd = request.getRequestDispatcher("cupcake.jsp");
            rd.forward(request, response);

        } else if ("cake".equals(action)) {
            sendCake(request, response);
        } else if ("cup".equals(action)) {
            sendCup(request, response);
        } else {
            sendNotFound(request, response);
        }
        Bottom b = cm.getBottom(request.getParameter("bottom"));
        Toppings t = cm.getTopping(request.getParameter("toppings"));
        request.setAttribute("bottom", b);
        request.setAttribute("toppings", t);
        RequestDispatcher rd = request.getRequestDispatcher("cupcake.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void sendLoginForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login</h1>");
            out.println("<form action=\"Main\" method=\"post\">");
            out.println("UserID: <input type=\"text\" name=\"userID\" />");
            out.println("Pasword: <input type=\"password\" name=\"password\" />");
            out.println("<input type=\"submit\" value=\"Login\">");
            out.println("<input type=\"hidden\" name=\"action\" value=\"login\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendCupcakes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Index</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Index</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendCake(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cake</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Let them have cake!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendCup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Here is a cup of tea!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void sendNotFound(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>NotFound</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Action not found</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
