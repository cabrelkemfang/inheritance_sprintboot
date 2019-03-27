package com.example.inheritance.controller;

import com.example.inheritance.model.Admin;
import com.example.inheritance.model.Sender;
import com.example.inheritance.model.User;
import com.example.inheritance.repository.AdminRepository;
import com.example.inheritance.repository.SenderRepository;
import com.example.inheritance.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  private final AdminRepository adminRepository;
  private final SenderRepository senderRepository;
  private final UserRepository userRepository;

  public UserController(final AdminRepository adminRepository,
                        final SenderRepository senderRepository,
                        final UserRepository userRepository) {
    super();
    this.adminRepository = adminRepository;
    this.senderRepository = senderRepository;
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public ResponseEntity<List<Admin>> getAllAdmin() {
    List<Admin> adminList = this.adminRepository.findAll();
    return new ResponseEntity<>(adminList, HttpStatus.OK);
  }

  @RequestMapping(value = "/sender", method = RequestMethod.GET)
  public ResponseEntity<List<Sender>> getAllPayer() {
    List<Sender> senderList = this.senderRepository.findAll();
    return new ResponseEntity<>(senderList, HttpStatus.OK);
  }

  @RequestMapping(value = "/create/admin", method = RequestMethod.POST)
  public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
    Admin admin1 = this.adminRepository.save(admin);
    return new ResponseEntity<>(admin1, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/create/sender", method = RequestMethod.POST)
  public ResponseEntity<Sender> createSender(@RequestBody Sender sender) {
    Sender sender1 = this.senderRepository.save(sender);
    return new ResponseEntity<>(sender1, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<List<User>> getAllUser() {
    List<User> userList = this.userRepository.findAll();
    return new ResponseEntity<>(userList, HttpStatus.OK);
  }

  @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
  public ResponseEntity<Admin> getAdmin(@PathVariable("id") String id) {
    Admin admin = this.adminRepository.findByIdentifier(id);
    return new ResponseEntity<>(admin, HttpStatus.OK);
  }

  @RequestMapping(value = "/sender/{id}", method = RequestMethod.GET)
  public ResponseEntity<Sender> getSender(@PathVariable("id") String id) {
    Sender sender = this.senderRepository.findByIdentifier(id);
    return new ResponseEntity<>(sender, HttpStatus.OK);
  }

  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
  public ResponseEntity<User> getuser(@PathVariable("id") String id) {
    User sender = this.userRepository.findByIdentifier(id);
    return new ResponseEntity<>(sender, HttpStatus.OK);
  }
}
