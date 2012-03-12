package com.nextinstruction.guice.examples.services;

public class FriendlyGreeter implements Greeter {

    @Override
    public String greet() {
        return "Howdy, Friend!";
    }
}