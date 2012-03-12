package com.nextinstruction.guice.examples;


import com.nextinstruction.guice.examples.servlets.GreeterServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyServletRunner {


    public static void main(String args[]) throws Exception {
        Server svr = new Server(8181);
        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/greetme");
        handler.setResourceBase(".");
        handler.addServlet(GreeterServlet.class, "/*");
        handler.setClassLoader(Thread.currentThread().getContextClassLoader());
        svr.setHandler(handler);
        svr.start();
        svr.join();

    }
}
