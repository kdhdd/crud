package week5.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week5.CRUD.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
