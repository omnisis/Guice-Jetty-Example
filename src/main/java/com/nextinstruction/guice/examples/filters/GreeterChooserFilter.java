package com.nextinstruction.guice.examples.filters;


import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.servlet.RequestScoped;
import com.nextinstruction.guice.examples.services.FriendlyGreeter;
import com.nextinstruction.guice.examples.services.Greeter;
import com.nextinstruction.guice.examples.services.SpanishGreeter;

import javax.inject.Singleton;
import javax.servlet.*;
import java.io.IOException;
import java.util.Random;

@Singleton
public class GreeterChooserFilter implements Filter {
    Random rnd = new Random();
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        int roll = rnd.nextInt(2);
        Greeter greeter = (roll > 0) ? new SpanishGreeter(): new FriendlyGreeter();

        System.out.println("Setting greeter type to: "+greeter.getClass().getCanonicalName());

        // sets the 'greeterType' request attributed to a random type
        request.setAttribute("greeter", greeter);

        // invoke the chain
        chain.doFilter(request,response);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
