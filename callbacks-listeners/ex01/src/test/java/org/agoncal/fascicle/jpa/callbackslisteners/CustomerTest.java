package org.agoncal.fascicle.jpa.callbackslisteners;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
public class CustomerTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void ageShouldBeGreaterThanZero() {
    Customer customer = new Customer("Rita", "Navalhas", "rnavalhas@gmail.com", "+351 123 4565");
    customer.setDateOfBirth(LocalDate.of(1975, 5, 27));

    customer.calculateAge();

    int calculatedAge = customer.getAge();

    assertTrue(calculatedAge >= 0);
  }

  @Test
  public void shouldCheckAgeIsNullCauseDateOfBirtheIsNull() {
    Customer customer = new Customer();
    customer.calculateAge();
    assertNull(customer.getAge());
  }

  @Test
  public void shouldCheckTheAgeOfTheCustomer() throws Exception {

    // Instanciates an object
    Customer customer = new Customer("John", "Smith", "jsmith@gmail.com", "1234565", LocalDate.now(), LocalDateTime.now());
    assertFalse(em.contains(customer));

    // Persists the object
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertTrue(em.contains(customer), "should be in the persistence context after persisting");
    assertEquals(new Integer(0), customer.getAge());

    // Finds the object
    customer = em.find(Customer.class, customer.getId());
    assertTrue(em.contains(customer), "should be in the persistence context after finding");
    assertEquals(new Integer(0), customer.getAge());

    // Removes the entity
    tx.begin();
    em.remove(customer);
    tx.commit();
    assertFalse(em.contains(customer), "should not be in the persistence context after removing");
  }

  @Test
  public void shouldThrowAnExceptionBecauseFirstNameIsNull() throws Exception {

    // Instanciates an object
    Customer customer = new Customer(null, "Smith", "jsmith@gmail.com", "1234565", LocalDate.now(), LocalDateTime.now());

    assertThrows(IllegalArgumentException.class, () -> {
      // Persist the object
      em.persist(customer);
    });
  }

  @Test
  public void shouldThrowAnExceptionBecauseLastNameIsNull() throws Exception {

    // Instanciates an object
    Customer customer = new Customer("John", null, "jsmith@gmail.com", "1234565", LocalDate.now(), LocalDateTime.now());

    assertThrows(IllegalArgumentException.class, () -> {
      // Persist the object
      em.persist(customer);
    });
  }
}
