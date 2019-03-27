package com.example.inheritance.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Sender extends User {

  @Column
  private String country;

  public Sender() {
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
