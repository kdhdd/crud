package week5.CRUD.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week5.CRUD.Service.CommentService;
import week5.CRUD.Service.MemberService;
import week5.CRUD.Service.PostService;
import week5.CRUD.domain.Comment;
import week5.CRUD.dto.CommentDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final MemberService memberService;
    private final PostService postService;

    @Autowired
    public CommentController(CommentService commentService, MemberService memberService, PostService postService) {
        this.commentService = commentService;
        this.memberService = memberService;
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> registerComment(@RequestBody CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setMember(memberService.getMemberById(commentDto.getMemberId()).orElse(null));
        comment.setPost(postService.getPostById(commentDto.getPostId()).orElse(null));

        Comment registeredComment = commentService.registerComment(comment);
        return ResponseEntity.ok(commentDto.from(registeredComment));
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        List<CommentDto> commentDtos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentDto dto = CommentDto.from(comment);
            commentDtos.add(dto);
        }
        return ResponseEntity.ok(commentDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable(name="id") Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name="id") Long id, @RequestBody CommentDto commentDto) {
        try {
            Comment updatedComment = commentService.updateComment(id, commentDto);
            return ResponseEntity.ok(commentDto.from(updatedComment));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
