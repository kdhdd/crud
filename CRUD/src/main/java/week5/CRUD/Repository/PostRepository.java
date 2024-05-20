package week5.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week5.CRUD.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
