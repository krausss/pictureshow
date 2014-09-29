package de.dhbw.pictureshow.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by krausss on 28.09.2014.
 */
@WebServlet(urlPatterns = "/bootstrap/css/bootstrap.css")
public class BootstrapCSS extends HttpServlet{


        @Override
        protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/css");
            final PrintWriter out = resp.getWriter();
            String src = "/assets/css/bootstrap.css";
            final InputStream cssStream = getClass().getResourceAsStream(src);
            final String css = new Scanner(cssStream).useDelimiter("\\A").next();
            out.write(css);
        }
}
