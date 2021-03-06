package dev.peruch.rxjavamongo.repositories;

import dev.peruch.rxjavamongo.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findBySecondName(String secondName);
}
