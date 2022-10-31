package com.nemacrux;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>My Fancy Bank</h1>\n" +
                            "<p>Welcome to the future of banking!</p>\n" +
                            "</body>\n" +
                            "</html>");
        }
        else if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().print(new ObjectMapper().writeValueAsString(App.trxService.findAll()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            resp.setContentType("application/json; charset=UTF-8");

            int trxId = Integer.parseInt(req.getParameter("id"));
            double amount = Double.parseDouble(req.getParameter("amount"));
            String ref = req.getParameter("ref");

            Transaction transaction = App.trxService.create(trxId, amount, ref);

            String json = new ObjectMapper().writeValueAsString(transaction);
            resp.getWriter().print(json);
        }
    }
}
