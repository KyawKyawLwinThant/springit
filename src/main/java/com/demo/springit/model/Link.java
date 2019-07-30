package com.demo.springit.model;

import com.demo.springit.service.BeanUtil;

import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Link extends Auditable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty(message = "Please enter a title.")
  private String title;
  @NotEmpty(message = "Please enter a url.")
  @URL(message = "Please enter a url.")
  private String url;

  @OneToMany(mappedBy = "link")
  private List<Comment> comments=new ArrayList<>();

  public Link() {
  }

  public Link( String title, String url) {
    this.title = title;
    this.url = url;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }


  public String getDomainName() throws URISyntaxException {
    URI uri = new URI(this.url);
    String domain = uri.getHost();
    return domain.startsWith("www.") ? domain.substring(4) : domain;
  }

  public String getPrettyTime() {
    PrettyTime pt = BeanUtil.getBean("prettyTime");
    System.out.println("Pretty Time:"+ pt.toString());
    return pt.format(convertToDateViaInstant(getCreationDate()));
  }

  private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
    return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
  }
}
