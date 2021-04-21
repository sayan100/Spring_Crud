package com.sayan.models;

import javax.persistence.*;

@Entity
@Table(name = "sm_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @PrimaryKeyJoinColumn
    private int id;

    @Column(name = "name")
    private String name;
    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
