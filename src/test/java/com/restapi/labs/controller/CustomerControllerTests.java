package com.restapi.labs.controller;

import com.restapi.labs.models.Customer;
import com.restapi.labs.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Test fixture for {@link CustomerController}.
 */
public class CustomerControllerTests {

  private CustomerRepository customerRepository;
  private CustomerController classUnderTest;

  @Before
  public void setUp() {
    customerRepository = mock(CustomerRepository.class);
    classUnderTest = new CustomerController(customerRepository);
  }

  /**
   * Test to ensure getCustomers returns all the customers.
   */
  @Test
  public void ensureGetAllCustomers() {
    when(customerRepository.findAll()).thenReturn(getAllCustomersExpectations());
    List<Customer> actual = classUnderTest.getCustomers();
    Assert.assertEquals(2, actual.size());

    Customer customer1 = actual.get(0);
    Assert.assertEquals("Mrudula", customer1.getFirstName());
    Assert.assertEquals("Sundru", customer1.getLastName());

    Customer customer2 = actual.get(1);
    Assert.assertEquals("Bhavana", customer2.getFirstName());
    Assert.assertEquals("Mallineni", customer2.getLastName());
  }

  /**
   * Test to ensure getCustomersCount returns total number of customers.
   */
  @Test
  public void ensureGetAllCustomersCount() {
    when(customerRepository.findAll()).thenReturn(getAllCustomersExpectations());
    int actual = classUnderTest.getCustomersCount();
    Assert.assertEquals(2, actual);
  }

  public List<Customer> getAllCustomersExpectations() {
    List<Customer> customers = new ArrayList<>();

    Customer customer1 = new Customer("Mrudula", "Sundru");
    customer1.setId(1L);
    Customer customer2 = new Customer("Bhavana", "Mallineni");
    customer2.setId(2L);
    customers.add(customer1);
    customers.add(customer2);

    return customers;
  }

}
