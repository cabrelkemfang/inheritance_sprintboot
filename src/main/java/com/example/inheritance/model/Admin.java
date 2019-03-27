package com.example.inheritance.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Admin  extends  User{
  @ManyToMany(fetch = FetchType.EAGER,cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
  })
  @JoinTable(name = "USERS_ROLES",
          joinColumns =  @JoinColumn(name ="USERS_ID"),inverseJoinColumns= @JoinColumn(name="ROLES_ID"))
  private Set<Role> roles;

  public Admin() {
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
