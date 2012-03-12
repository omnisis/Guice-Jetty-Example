package com.nextinstruction.guice.examples.services;

class FriendlyGreeter implements Greeter {

    @Override
    public String greet() {
        return "Howdy, Friend!";
    }
}