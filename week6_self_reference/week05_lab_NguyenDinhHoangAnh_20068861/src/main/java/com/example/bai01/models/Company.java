package com.example.bai01.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id", columnDefinition = "bigint(20)")
    private long id;
    @Column(name = "comp_name")
    private String name;
    @Column(name = "about", columnDefinition = "varchar(2000)")
    private String about;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    private Address address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "web_url")
    private String webURL;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Job> jobs;
    @Column(name = "email")
    private String email;
}
