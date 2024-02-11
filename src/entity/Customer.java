package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Two types of annotations are used to map a class to a table

// 1. @Entity(name = "customer")
// 2.
 @Entity // this is used to tell hibernate that this class is an entity
 @Table(name = "customer") // this is used to tell hibernate that this class is mapped to a table
public class Customer {

     @Id // this is used to tell hibernate that this field is the primary key
     @Column(name = "customer_id") // this is used to tell hibernate that this field is a column in the table
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_salary")
    private double salary;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
    }

    public Customer() {
        // default constructor
    }



}
