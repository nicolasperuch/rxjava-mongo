package dev.peruch.rxjavamongo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String secondName;

    public Customer() {}

    public Customer(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}

