package com.restapi.labs.controller;

import com.restapi.labs.models.Customer;
import com.restapi.labs.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

  private final CustomerRepository customerRepository;
  private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    logger.info("Getting all the customers ...");
    return (List<Customer>) customerRepository.findAll();
  }

  @GetMapping("/customers/count")
  public int getCustomersCount() {
    logger.info("Getting total customers count ...");
    List<Customer> customers = (List<Customer>) customerRepository.findAll();
    return customers.size();
  }

  @GetMapping("/customers/{customerId}")
  public Optional<Customer> getCustomerById(@PathVariable Long customerId) {
    logger.info(String.format("Getting customer by customer id %s ...", customerId));
    return customerRepository.findById(customerId);
  }

  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer customer) {
    logger.info("Adding new customer ...");
    return customerRepository.save(customer);
  }

  @PutMapping("/customers/{customerId}")
  public Customer replaceCustomer(@RequestBody Customer newCustomer,
                                  @PathVariable Long customerId) {
    logger.info(String.format("Replacing customer with id %s ...", customerId));
    return customerRepository.findById(customerId)
        .map(customer -> {
          customer.setFirstName(customer.getFirstName());
          customer.setLastName(customer.getLastName());
          return customerRepository.save(customer);
        })
        .orElseGet(() -> {
          newCustomer.setId(customerId);
          return customerRepository.save(newCustomer);
        });
  }

  @DeleteMapping("/customers/{customerId}")
  public String removeCustomer(@PathVariable Long customerId) {
    logger.info(String.format("Removing customer with id %s", customerId));
    Optional<Customer> customer = customerRepository.findById(customerId);
    customerRepository.deleteById(customerId);
    return String.format("successfully deleted a customer %s %s",
        customer.get().getFirstName(), customer.get().getLastName());
  }
}
