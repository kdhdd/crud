package week5.CRUD.dto;

import lombok.Getter;
import lombok.Setter;
import week5.CRUD.domain.Comment;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String content;
    private LocalDateTime registerDate;
    private Long memberId;
    private Long postId;

    public static CommentDto from(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setRegisterDate(comment.getRegisterDate());
        if (comment.getMember() != null) {
            commentDto.setMemberId(comment.getMember().getId());
        }
        if (comment.getPost() != null) {
            commentDto.setPostId(comment.getPost().getId());
        }
        return commentDto;
    }
}
