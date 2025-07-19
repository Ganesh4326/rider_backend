package com.rider.rider;

import com.rider.rider.learnings.TomcatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RiderApplication implements CommandLineRunner {

    @Autowired
    private TomcatInfo tomcatInfo;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RiderApplication.class, args);
        TomcatInfo tomcatInfo = context.getBean(TomcatInfo.class);
        tomcatInfo.printTomcatInfo();
    }

    @Override
    public void run(String... args) throws Exception {
//        tomcatInfo.printTomcatInfo();
    }
}
