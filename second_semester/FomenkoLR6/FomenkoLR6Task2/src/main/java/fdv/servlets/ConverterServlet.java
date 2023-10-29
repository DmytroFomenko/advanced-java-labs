package fdv.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static fdv.servlets.MainPageServlet.conv;



@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fromCur = request.getParameter("fromCur");
        String fromSum = request.getParameter("fromSum");
        String toCur = request.getParameter("toCur");

        conv.convert(fromCur, fromSum, toCur);


        String path = request.getContextPath() + "/MainPageServlet";
        response.sendRedirect(path);
    }
}
