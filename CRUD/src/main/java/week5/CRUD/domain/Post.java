package week5.CRUD.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {
    @Id // 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본키의 값을 생성할 전략을 지정
    @Column(name = "post_id")
    private Long id;

    @ManyToOne // 다대일 관계
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;
    private String content;
    @CreationTimestamp // 현재 시간으로 타임스탬프 생성
    private LocalDateTime registerDate;

    @OneToMany(mappedBy = "post") // 일대다 관계, post에 의해 매핑
    private List<Comment> comments = new ArrayList<>();
}
