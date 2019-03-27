package com.example.inheritance.repository;

import com.example.inheritance.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBaseRepository<T extends User> extends JpaRepository<T, Long> {
  T findByIdentifier(final String identifier);

}
