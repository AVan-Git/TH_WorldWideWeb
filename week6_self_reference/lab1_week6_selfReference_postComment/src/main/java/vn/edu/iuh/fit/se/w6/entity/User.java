package vn.edu.iuh.fit.se.w6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "middle_name", length = 50)
    private String middleName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "mobile", length = 15)
    private String mobile;
    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;
    @Column(name = "password_hasd", length = 32, nullable = false)
    private String passwordHasd;
    @Column(name = "registered_at")
    private LocalDate registeredAt;
    @Column(name = "last_login")
    private String lastLogin;
    @Column(name = "intro")
    private char intro;
    @Column(name = "profile")
    private String profile;

    //Jpa
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    @OneToMany(mappedBy = "user")
    private List<PostComment> postCommentList;



}
