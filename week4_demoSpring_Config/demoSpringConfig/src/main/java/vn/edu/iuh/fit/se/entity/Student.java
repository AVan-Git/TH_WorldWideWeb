package vn.edu.iuh.fit.se.entity;

public class Student {

    private long id ;
    private String name;

    private Classs classs;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classs=" + classs +
                '}';
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
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

    public Student(long id, String name, Classs classs) {
        this.id = id;
        this.name = name;
        this.classs = classs;
    }
}
