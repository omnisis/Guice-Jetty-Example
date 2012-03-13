package com.nextinstruction.guice.examples.servlets;

import com.nextinstruction.guice.examples.services.Greeter;

import javax.inject.Singleton;

@Singleton
public class GuiceParameterizedRequestGreeterServlet extends GreeterServlet {

    @Override
    protected String getBody() {
        return ((Greeter)req.getAttribute("greeter")).greet();
    }
}

