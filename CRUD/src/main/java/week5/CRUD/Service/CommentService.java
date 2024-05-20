package week5.CRUD.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week5.CRUD.Repository.CommentRepository;
import week5.CRUD.domain.Comment;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Transactional
    public Comment registerComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
    public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

}