package com.nextinstruction.guice.examples.servlets;

import com.nextinstruction.guice.examples.services.Greeter;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GuiceGreeterServlet extends GreeterServlet {
    private Greeter myGreeter;

    @Inject
    public void setMyGreeter(Greeter myGreeter) {
        this.myGreeter = myGreeter;
    }

    @Override
    protected String getBody() {
        return "Greeter says: " + myGreeter.greet();
    }
}
