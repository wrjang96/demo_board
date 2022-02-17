package com.my_board_project.springboot.domain.posts;
import com.my_board_project.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    private Long fileId;
    @Builder
    public Posts(String title, String content, String author, Long fileId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.fileId = fileId;
    }

    public void update(String title, String content, Long fileId) {
        this.title = title;
        this.content = content;
        this.fileId = fileId;
    }
    @Override
    public String toString() {
        return "Posts{" +
                "Id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", fileId='" + fileId + '\'' +
                '}';
    }
}