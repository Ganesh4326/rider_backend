package com.rider.rider;

import com.rider.rider.learnings.TomcatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static com.rider.rider.rides.util.base.DistanceCalculator.calculateDistance;

@SpringBootApplication
public class RiderApplication implements CommandLineRunner {

    @Autowired
    private TomcatInfo tomcatInfo;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RiderApplication.class, args);
        TomcatInfo tomcatInfo = context.getBean(TomcatInfo.class);
//        tomcatInfo.printTomcatInfo();
    }

    @Override
    public void run(String... args) throws Exception {
        double lat1 = 17.387592171764222, lon1 = 78.35734416906432;
        double lat2 = 17.395741957724876, lon2 = 78.37185310474479;

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.printf("Distance: %.2f km%n", distance);
//        tomcatInfo.printTomcatInfo();
    }
}
