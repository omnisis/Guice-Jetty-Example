/*
 * Created by IntelliJ IDEA.
 * User: cliffordjames
 * Date: 3/12/12
 * Time: 12:17 AM
 */
package com.nextinstruction.guice.examples.modules;

import com.google.inject.servlet.ServletModule;
import com.nextinstruction.guice.examples.filters.GreeterChooserFilter;
import com.nextinstruction.guice.examples.servlets.GreeterServlet;
import com.nextinstruction.guice.examples.servlets.GuiceGreeterServlet;
import com.nextinstruction.guice.examples.servlets.GuiceParameterizedRequestGreeterServlet;

public class GreeterServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
            /* Filters */
            filter("/*").through(GreeterChooserFilter.class);

            /* Servlets */
            bind(GreeterServlet.class);
            bind(GuiceGreeterServlet.class);

           /* Servlet Mappings */
           serve("/greetme").with(GreeterServlet.class);
           serve("/greetme-guice").with(GuiceGreeterServlet.class);
           serve("/greetme-provided").with(GuiceParameterizedRequestGreeterServlet.class);
    }
}
