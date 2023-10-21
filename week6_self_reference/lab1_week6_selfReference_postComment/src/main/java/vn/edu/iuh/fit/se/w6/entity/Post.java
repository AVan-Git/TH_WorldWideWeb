package vn.edu.iuh.fit.se.w6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;
    @Column(name = "title", length = 75, nullable = false)
    private String title;
    @Column(name = "meta_title", length = 100)
    private String metaTitle;
    @Column(name = "summary")
    private char summary;
    @Column(name = "published", nullable = false,columnDefinition = "tinyint default 0")
    private byte published;
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "update_at")
    private LocalDate updateAt;
    @Column(name = "published_at")
    private LocalDate publishedAt;
    @Column(name = "content")
    private String content;

//JPA
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User user;// tblUser

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post post;// tblPost

    @OneToMany(mappedBy = "post")
    private List<Post> postList;


    @OneToMany(mappedBy = "post")
    private List<PostComment> postComments;

}
