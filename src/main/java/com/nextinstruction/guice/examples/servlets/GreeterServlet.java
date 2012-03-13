package com.nextinstruction.guice.examples.servlets;

import com.nextinstruction.guice.examples.handler.GreeterViewHandler;

import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Singleton
public class GreeterServlet extends HttpServlet {
    private GreeterViewHandler viewHandler = new GreeterViewHandler();
    protected HttpServletRequest req;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.req = req;
        final PrintWriter out = resp.getWriter();
        viewHandler.outputPreBody(out);
        viewHandler.outputBody(out, getBody());
        viewHandler.outputPostBody(out);
    }

   protected String getBody() {
       return "Hello from GreeterServlet!";
   }
}
