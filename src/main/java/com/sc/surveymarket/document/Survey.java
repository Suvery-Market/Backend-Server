package com.sc.surveymarket.document;

import com.sc.surveymarket.document.question.Question;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Document
@Getter
@NoArgsConstructor
public class Survey {

    @Id
    @Column(name = "survey_id")
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @Column(nullable = false)
    private User user;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private List<Question> questionList;

    @CreatedDate // Insert
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Insert or Update
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Version
    private Integer version;

    @Builder
    public Survey(User user, String title, List<Question> questionList) {
        this.user = user;
        this.title = title;
        this.questionList = questionList;
    }
}
