package org.agoncal.fascicle.jpa.querying;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import static javax.persistence.CascadeType.PERSIST;


/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Entity
@NamedQuery(name = "findAll", query = "SELECT c FROM Customer c")
@NamedQuery(name = "findVincent", query = "SELECT c FROM Customer c WHERE c.firstName = 'Vincent'")
@NamedQuery(name = "findWithParam", query = "SELECT c FROM Customer c WHERE c.firstName = :fname")
public class Customer {

  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer age;
  @OneToOne(cascade = {PERSIST})
  private Address address;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public static final String FIND_ALL = "Customer.findAll";

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
  // end::adocSkip[]
}
// end::adocSnippet[]
