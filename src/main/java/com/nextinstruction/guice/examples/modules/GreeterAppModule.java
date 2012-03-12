/*
 * Created by IntelliJ IDEA.
 * User: cliffordjames
 * Date: 3/12/12
 * Time: 12:13 AM
 */
package com.nextinstruction.guice.examples.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.nextinstruction.guice.examples.services.FriendlyGreeter;
import com.nextinstruction.guice.examples.services.Greeter;


public class GreeterAppModule extends AbstractModule {

    @Override
    protected void configure() {
        // creates a singleton binding of greeter => friendly Greeter
        bind(Greeter.class).to(FriendlyGreeter.class).in(Scopes.SINGLETON);
    }
}
