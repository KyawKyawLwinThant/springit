package com.demo.springit.model;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min=8,max = 20)
  @Column(nullable = false,unique = true)
  private String email;
  @Column(length = 100)
  private String password;

  @Column(nullable = false)
  private boolean enabled;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public User(){

  }

  public User(@NonNull @Size(min = 8, max = 20) String email, String password, @NonNull boolean enabled) {
    this.email = email;
    this.password = password;
    this.enabled = enabled;
  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "users_roles",
          joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
  )
  private Set<Role> roles = new HashSet<>();


  public void addRole(Role role){
    roles.add(role);
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return  roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  public void addRoles(HashSet<Role> roles) {
    this.roles.addAll(roles);
  }
}
