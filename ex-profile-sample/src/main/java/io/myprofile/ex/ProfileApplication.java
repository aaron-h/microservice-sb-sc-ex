package io.myprofile.ex;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ProfileApplication {
	public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(ProfileApplication.class)
                .profiles("production")
                .run(args);
    }
}
