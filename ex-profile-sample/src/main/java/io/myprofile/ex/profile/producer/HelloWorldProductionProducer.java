package io.myprofile.ex.profile.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("production")
@Configuration
public class HelloWorldProductionProducer {

    @Bean(name = "helloWorld")
    public String produceHelloWorld() {
        return "Hello production world!";
    }

}
