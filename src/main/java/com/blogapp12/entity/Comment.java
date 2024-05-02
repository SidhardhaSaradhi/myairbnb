package com.blogapp12.entity;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

@Data
@Entity
@Table(name="comments")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String message;
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
}
