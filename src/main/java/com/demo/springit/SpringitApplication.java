package com.demo.springit;

import com.demo.springit.config.SpringitProperties;
import com.demo.springit.model.Comment;
import com.demo.springit.model.Link;
import com.demo.springit.repository.CommentRepository;
import com.demo.springit.repository.LinkRepository;
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
  CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
    return  args -> {
      Link link=new Link("thaw thaw","thawthaw@gmail.com");



      Comment comment=new Comment("This is spring boot2",link);

      link.getComments().add(comment);
      linkRepository.save(link);
      commentRepository.save(comment);

    };
  }
}
