package vn.edu.iuh.fit.se.entity;

public class Student {

    private long id ;
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
