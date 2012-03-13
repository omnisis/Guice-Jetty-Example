package com.nextinstruction.guice.examples.services;


public class SpanishGreeter implements Greeter {
    @Override
    public String greet() {
        return "Hola, Senor!";
    }
}
