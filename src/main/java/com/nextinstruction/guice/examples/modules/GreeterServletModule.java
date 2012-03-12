/*
 * Created by IntelliJ IDEA.
 * User: cliffordjames
 * Date: 3/12/12
 * Time: 12:17 AM
 */
package com.nextinstruction.guice.examples.modules;

import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.ServletModule;
import com.nextinstruction.guice.examples.servlets.GreeterServlet;
import com.nextinstruction.guice.examples.servlets.GuiceGreeterServlet;
import org.eclipse.jetty.servlet.DefaultServlet;

public class GreeterServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
            /* Servlets */
            bind(GreeterServlet.class).in(Scopes.SINGLETON);
            bind(GuiceGreeterServlet.class).in(Scopes.SINGLETON);

           /* Servlet Mappings */
           serve("/greetme").with(GreeterServlet.class);
           serve("/greetme-guice").with(GuiceGreeterServlet.class);
    }
}
