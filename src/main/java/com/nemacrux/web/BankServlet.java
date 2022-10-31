package com.nemacrux.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nemacrux.model.Transaction;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.nemacrux.context.Application.trxService;

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
            response.getWriter().print(new ObjectMapper().writeValueAsString(trxService.findAll()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            resp.setContentType("application/json; charset=UTF-8");

            double amount = Double.parseDouble(req.getParameter("amount"));
            String ref = req.getParameter("ref");

            Transaction transaction = trxService.create(amount, ref);

            String json = new ObjectMapper().writeValueAsString(transaction);
            resp.getWriter().print(json);
        }
    }
}
