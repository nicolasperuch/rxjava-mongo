package dev.peruch.rxjavamongo.controller;

import dev.peruch.rxjavamongo.entities.Customer;
import dev.peruch.rxjavamongo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    CustomerService customerService;

    @GetMapping("/find")
    public List<Customer> listCustomers(){
        return customerService.findAll();
    }
}
