package vn.edu.iuh.fit.se.w6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "post_comment")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private long id;
    @Column(name = "title", length = 100 )
    private String title;
    @Column(name = "published", nullable = false,columnDefinition = "tinyint default 0")
    private byte published;
    @Column(name = "create_at", nullable = false )
    private LocalDate createAt;
    @Column(name = "published_at" )
    private LocalDate publishedAt;
    @Column(name = "content" )
    private String content;

    //JPA
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment postComment;

    @OneToMany(mappedBy = "postComment")
    private List<PostComment> postCommentList;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;// tblUser
}
