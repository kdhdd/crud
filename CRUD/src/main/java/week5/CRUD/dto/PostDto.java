package week5.CRUD.dto;

import lombok.Getter;
import lombok.Setter;
import week5.CRUD.domain.Post;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime registerDate;
    private Long memberId;

    public static PostDto from(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setRegisterDate(post.getRegisterDate());
        if (post.getMember() != null) {
            postDto.setMemberId(post.getMember().getId());
        }
        return postDto;
    }
}
