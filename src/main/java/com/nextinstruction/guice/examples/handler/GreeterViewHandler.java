package com.nextinstruction.guice.examples.handler;

import java.io.PrintWriter;

public class GreeterViewHandler {
    public void outputPreBody(PrintWriter out) {
        out.println("<html><head><title>");
        out.println(getTitle());
        out.println("</title></head>");
    }

    private String getTitle() {
        return "Greeter Example App";
    }

    public void outputBody(PrintWriter out, String bodyText) {
        out.println("<body>");
        out.println(bodyText);
        out.println("</body>");
    }
    public void outputPostBody(PrintWriter out)  {
        out.println("</html>");
    }
}
