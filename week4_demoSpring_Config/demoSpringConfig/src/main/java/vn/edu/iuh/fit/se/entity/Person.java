package vn.edu.iuh.fit.se.entity;

import java.util.List;

public class Person {
    private int age;
    private List<String> emails;
    private String name;
    private  List<Address> lstAddress;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", emails=" + emails +
                ", name='" + name + '\'' +
                ", lstAddress=" + lstAddress +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getLstAddress() {
        return lstAddress;
    }

    public void setLstAddress(List<Address> lstAddress) {
        this.lstAddress = lstAddress;
    }

    public Person() {
    }

    public Person(int age, List<String> emails, String name, List<Address> lstAddress) {
        this.age = age;
        this.emails = emails;
        this.name = name;
        this.lstAddress = lstAddress;
    }
}
