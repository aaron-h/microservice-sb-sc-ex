package io.myprofile.ex.profile.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("test")
@Configuration
public class HelloWorldTestProducer {

    private Log LOG = LogFactory.getLog(HelloWorldTestProducer.class);

    @PostConstruct
    public void init() {
        LOG.info("test world has been produced");
    }

    @Bean(name = "helloWorld")
    public String produceHelloWorld() {
        return "Hello test world!";
    }

}
