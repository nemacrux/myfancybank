package com.nemacrux;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BankServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(
                        "<html>\n" +
                            "<body>\n" +
                                "<h1>My Fancy Bank</h1>\n" +
                                "<p>Welcome to the future of banking!</p>\n" +
                            "</body>\n" +
                        "</html>");
    }
}
