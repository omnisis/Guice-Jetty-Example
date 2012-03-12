package com.nextinstruction.guice.examples;


import com.google.inject.Guice;
import com.google.inject.servlet.GuiceFilter;
import com.nextinstruction.guice.examples.modules.GreeterAppModule;
import com.nextinstruction.guice.examples.modules.GreeterServletModule;
import org.eclipse.jetty.server.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;

import java.util.EnumSet;

public class JettyServletRunner {


    public static void main(String args[]) throws Exception {
        Server svr = new Server(8181);

        // guice-powered greetme servlet
        ServletContextHandler handler = new ServletContextHandler();
        handler.setResourceBase(".");

        // Register Guice Filter
        handler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        svr.setHandler(handler);

        // add a lifecycle listener to bootstrap injector on startup
        svr.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
            @Override
            public void lifeCycleStarted(LifeCycle event) {
                System.out.println("Bootstrapping Guice injector ...");
                Guice.createInjector(new GreeterServletModule(), new GreeterAppModule());
            }
        });

        handler.addServlet(DefaultServlet.class, "/");

        svr.start();
        svr.join();
        

    }
}
