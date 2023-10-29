package fdv.servlets;


import fdv.logic.Converter;

import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {


    public static Converter conv = null;

    public void init() throws ServletException {
        conv = new Converter();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("langNum", conv.getLang());

        request.setAttribute("title", conv.getBund().getString("logo"));
        request.setAttribute("choose", conv.getBund().getString("choose"));
        request.setAttribute("chooseLangLabel", conv.getBund().getString("chooseLangLabel"));
        request.setAttribute("UAH", conv.getBund().getString("uah"));
        request.setAttribute("USD", conv.getBund().getString("usd"));
        request.setAttribute("EUR", conv.getBund().getString("eur"));
        request.setAttribute("from", conv.getBund().getString("from"));
        request.setAttribute("to", conv.getBund().getString("to"));
        request.setAttribute("exchangeOnLabel", conv.getBund().getString("exchangeOnLabel"));
        request.setAttribute("changing", conv.getBund().getString("changing"));
        request.setAttribute("get", conv.getBund().getString("get"));

        request.setAttribute("datePattern", conv.getBund().getString("datePattern"));
        request.setAttribute("langAbbr", conv.getBund().getLocale().getLanguage());
        request.setAttribute("date", conv.getDate());
        request.setAttribute("fromSum", conv.getFromSum());
        request.setAttribute("toSum", conv.getToSum());

        request.setAttribute("selFromUAH", conv.getSelFromUAH());
        request.setAttribute("selFromEUR", conv.getSelFromEUR());
        request.setAttribute("selFromUSD", conv.getSelFromUSD());

        request.setAttribute("selToUAH", conv.getSelToUAH());
        request.setAttribute("selToEUR", conv.getSelToEUR());
        request.setAttribute("selToUSD", conv.getSelToUSD());


        String path = "/index.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String lang = request.getParameter("language");
        conv.setBund(ResourceBundle.getBundle("Text", new Locale(lang)));

        String path = request.getContextPath() + "/MainPageServlet";
        response.sendRedirect(path);

    }

}