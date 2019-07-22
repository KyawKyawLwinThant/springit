package com.demo.springit;

import com.demo.springit.config.SpringitProperties;
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

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

  private static final Logger log= LoggerFactory.getLogger(SpringitApplication.class);

  @Autowired
  private SpringitProperties springitProperties;

  @Autowired
  private ApplicationContext applicationContext;

  public static void main(String[] args) {
    SpringApplication.run(SpringitApplication.class, args);
    System.out.println("Welcome to Spring It");
  }

  @Bean
  @Profile("dev")
  CommandLineRunner runner(){
    return  args -> {
      System.out.println("This is something that we would only do in dev.");
      System.out.println("================================================");
      String[] beans=applicationContext.getBeanDefinitionNames();
      Arrays.sort(beans);
      Arrays.stream(beans).forEach(System.out::println);

      log.error("CommandLineRunner.run()");
      log.warn("CommandLineRunner.run()");
      log.info("CommandLineRunner.run()");
      log.debug("CommandLineRunner.run()");
      log.trace("CommandLineRunner.run()");
    };
  }
}
