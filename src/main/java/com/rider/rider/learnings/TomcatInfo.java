package com.rider.rider.learnings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TomcatInfo {

    //holds running web server instance
    @Autowired
    private ServletWebServerApplicationContext servletWebServerApplicationContext;

//    @PostConstruct
    public void printTomcatInfo() {
        //get web server object from web server instance servlet context
        TomcatWebServer tomcatWebServer = (TomcatWebServer) servletWebServerApplicationContext.getWebServer();
        if (tomcatWebServer != null && tomcatWebServer.getTomcat().getServer().getState().isAvailable()) {
            System.out.println("Tomcat is running on: " + tomcatWebServer.getPort());
        } else {
            System.out.println("Tomcat is not running");
        }
    }
}
