package io.myprofile.ex.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class GreetController implements CommandLineRunner {

    private Log LOG = LogFactory.getLog(GreetController.class);

    @Autowired
    private Environment environment;

    @Qualifier("helloWorld")
    @Autowired
    String helloWorld;

    @Override
    public void run(String... args) throws Exception {
        LOG.info(String.format("You can say whatever you like, but based on the active profiles (%s) I can only say: %s", getFormattedActiveProfiles(), helloWorld));
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    private String getFormattedActiveProfiles() {
        return Arrays.asList(environment.getActiveProfiles()).stream().collect(Collectors.joining(", "));
    }
}
