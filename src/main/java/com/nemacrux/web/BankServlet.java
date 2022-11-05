package com.nemacrux.web;

import com.nemacrux.model.Transaction;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.nemacrux.context.Application.objectMapper;
import static com.nemacrux.context.Application.transactionsService;

public class BankServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getRequestURI().equalsIgnoreCase("/")) {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print(
                            """
                            <html>
                             <body>
                              <h1>My Fancy Bank</h1>
                              <p>Welcome to the future of banking!</p>
                             </body>
                            </html>
                            """);
        }
        else if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            List<Transaction> transactions = transactionsService.findAll();
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(objectMapper.writeValueAsString(transactions));
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {

            double amount = Double.parseDouble(req.getParameter("amount"));
            String ref = req.getParameter("ref");

            Transaction transaction = transactionsService.create(amount, ref);

            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(objectMapper.writeValueAsString(transaction));

        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
