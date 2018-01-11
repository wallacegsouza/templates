package ${pkg}.domain;

import org.hibernate.annotations.Entity;

@Entity
public class User {

  private String name;
  private String login;
  private String password;

  public User() { }

}