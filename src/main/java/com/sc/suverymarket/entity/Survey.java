package com.sc.suverymarket.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "Surveys")
public class Survey {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private User user;

    @Column(nullable = false, length = 100)
    private String title;

    @OneToMany(mappedBy = "survey", cascade = ALL)
    private List<Question> questionList = new ArrayList<>();

    @CreatedDate // Insert
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Insert or Update
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Builder
    public Survey(Long id, User user, String title, List<Question> questionList, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.questionList = questionList;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
