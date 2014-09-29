package de.dhbw.pictureshow.servlet;

import de.dhbw.pictureshow.database.Transaction;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by krausss on 22.09.2014.
 */

@WebServlet(name="Peter", urlPatterns ={"/login","/registry"})
public class registry extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Login</title></head>");
            out.println("<body>");
            String userName = request.getParameter("user");
            String password = request.getParameter("password");

        //    if (userName != null && !userName.trim().isEmpty()) {
        //        // Name vorhanden -> begruessen
        //        out.println("<h2>Hallo " + userName + "!</h2>");
        //        out.println("<a href=\"login\">Zurück</a>");

            String req_user ="Sascha";
            String req_password ="1234";

            if (userName != null && !userName.trim().isEmpty()) {
                if (userName.equals(req_user) && password.equals(req_password)) {
                    // Name vorhanden -> begruessen
                    out.println("<h2>Hallo " + userName + "!</h2>");
                    out.println("<a href=\"login\">Zurück</a>");
                }

            } else {
                // kein Name -> Eingabeformular anzeigen
                out.println("<h2>Login</h2>");
                out.println("<form method=\"POST\" action=\"login\">");
                out.println("User");
                out.println("<input type=\"text\" name=\"user\">");
                out.println("Password");
                out.println("<input type=\"password\" name=\"password\">");
                out.println("<input type=\"submit\" value=\"Login\">");
                out.println("</form>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
}