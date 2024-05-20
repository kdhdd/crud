package week5.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week5.CRUD.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
