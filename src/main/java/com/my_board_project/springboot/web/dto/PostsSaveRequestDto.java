package com.my_board_project.springboot.web.dto;
import com.my_board_project.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Long fileId;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, Long fileId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.fileId = fileId;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .fileId(fileId)
                .build();
    }

}