package dev.peruch.rxjavamongo.service;

import dev.peruch.rxjavamongo.entity.Customer;
import dev.peruch.rxjavamongo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void salvar(String nome, String conteudo) {
        customerRepository.save(new Customer(nome, conteudo));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }



    public long count() {
        return customerRepository.count();
    }
}

