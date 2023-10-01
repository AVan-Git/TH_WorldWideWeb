package vn.edu.iuh.fit.se.entity;

public class Classs {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classs() {
    }

    public Classs(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classs{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
