package com.nextinstruction.guice.examples.services;

import org.junit.Test;
import com.google.inject.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FriendlyGreeterTest {

    @Test
    public void testInjectionNoIF() {
        Injector injector = Guice.createInjector();
        FriendlyGreeter fg1 = injector.getInstance(FriendlyGreeter.class);
        FriendlyGreeter fg2 = injector.getInstance(FriendlyGreeter.class);
        assertNotNull(fg1);
        assertNotNull(fg2);
        assertFalse(fg1 == fg2);
    }

    static class AppModule1 implements Module {
        @Override
        public void configure(Binder binder) {
            binder.bind(Greeter.class).to(FriendlyGreeter.class);
        }
    }
    @Test
    public void testInjectionWithBindings() {
        Injector injector = Guice.createInjector(new AppModule1());
        Greeter greeter = injector.getInstance(Greeter.class);
        assert(greeter instanceof FriendlyGreeter);
    }
    
    static class AppModuleGlobal implements  Module {
        @Override
        public void configure(Binder binder) {
            binder.bind(Greeter.class).to(FriendlyGreeter.class).in(Scopes.SINGLETON);
        }
    }

    @Test
    public void testSingletonBinding() {
        Injector injector = Guice.createInjector(new AppModuleGlobal());
        Greeter g1 = injector.getInstance(Greeter.class);
        Greeter g2 = injector.getInstance(Greeter.class);
        assertTrue(g1 == g2);
    }
}
