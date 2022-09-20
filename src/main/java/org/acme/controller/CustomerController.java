package org.acme.controller;

import org.acme.entity.Customer;
import org.acme.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/api/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> retrieveCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            customers = customerService.findAllCustomers();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customers;
    }

    @POST
    @Transactional
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }
}
