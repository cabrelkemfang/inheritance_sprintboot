package com.example.inheritance.repository;

import com.example.inheritance.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UserBaseRepository<User> {

  @Query("SELECT CASE WHEN COUNT(c) > 0 THEN 'true' ELSE 'false' END FROM User c WHERE c.identifier = :identifier")
  Boolean existsByIdentifier(@Param("identifier") final String identifier);

  //Optional<User> findById(final Long identifier);

  //User findByIdentifier(final String identifier);

}
