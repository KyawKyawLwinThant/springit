package com.demo.springit.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;



@Entity
public class Role {
  @Id
  @GeneratedValue
  private Long id;


  private String name;

  @ManyToMany( mappedBy = "roles")
  private Collection<User> users;

  public Role() {
  }

  public Role( String name) {
    this.name = name;

  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }
}
