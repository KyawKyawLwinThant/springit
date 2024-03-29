package com.demo.springit;

import com.demo.springit.config.SpringitProperties;
import com.demo.springit.model.Comment;
import com.demo.springit.model.Link;
import com.demo.springit.repository.CommentRepository;
import com.demo.springit.repository.LinkRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)

public class SpringitApplication {




  public static void main(String[] args) {
    SpringApplication.run(SpringitApplication.class, args);

  }

  @Bean
  public PrettyTime prettyTime(){
    return new PrettyTime();
  }

  // TODO * Configuring this bean should not be needed once Spring Boot's Thymeleaf starter includes configuration
// TODO   for thymeleaf-extras-springsecurity5 (instead of thymeleaf-extras-springsecurity4)
  @Bean
  public SpringSecurityDialect securityDialect() {
    return new SpringSecurityDialect();
  }


}
