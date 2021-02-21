package softuni.judge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge.model.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
