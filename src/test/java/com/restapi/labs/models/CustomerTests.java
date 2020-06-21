package com.restapi.labs.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTests {

  private Customer classUnderTest;
  private ObjectMapper objectMapper;

  @Before
  public void setUp() {
    classUnderTest = new Customer();
    objectMapper = new ObjectMapper();
  }

  /**
   * Test first name Accessor for {@link Customer}.
   */
  @Test
  public void ensureCustomerFistNameAccessors() {
    String expected = "Chaitanya";
    String actual = classUnderTest.getFirstName();
    Assert.assertNotEquals(expected, actual);

    classUnderTest.setFirstName(expected);
    actual = classUnderTest.getFirstName();
    Assert.assertEquals(expected, actual);
  }

  /**
   * Test last name Accessor for {@link Customer}.
   */
  @Test
  public void ensureCustomerLastNameAccessors() {
    String expected = "Rayala";
    String actual = classUnderTest.getLastName();
    Assert.assertNotEquals(expected, actual);

    classUnderTest.setLastName(expected);
    actual = classUnderTest.getLastName();
    Assert.assertEquals(expected, actual);
  }

  /**
   * Test if Customer json data can be deserialized to java objects.
   */
  @Test
  public void ensureCustomerDeserialization() throws JsonProcessingException {
    String json = "[{ \"firstName\": \"Chaitanya\", "
        + "\"lastName\": \"Rayala\"},"
        + "{\"firstName\": \"Pruthvi\","
        + "\"lastName\": \"Sambu\"}]";

    Customer[] customers = objectMapper.readValue(json, Customer[].class);

    Customer customer1 = customers[0];
    Assert.assertEquals("Chaitanya", customer1.getFirstName());
    Assert.assertEquals("Rayala", customer1.getLastName());

    Customer customer2 = customers[1];
    Assert.assertEquals("Pruthvi", customer2.getFirstName());
    Assert.assertEquals("Sambu", customer2.getLastName());
  }
}
