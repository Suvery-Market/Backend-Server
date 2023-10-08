package com.sc.suverymarket.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "Questions")
public class Question {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private Survey survey;

    @Column(nullable = false, length = 100)
    private String header;

    @Column(nullable = false, length = 100)
    private String body;

    @Column(nullable = false, updatable = false)
    @Enumerated(value = STRING)
    private Type type;


    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    public enum Type {
        SHORT_ANSWER("단답형"),
        LONG_ANSWER("장문형"),
        MULTIPLE_CHOICE("객관식"),
        CHECK_BOX("체크박스"),
        DROP_DOWN("드롭다운"),
        LINEAR_SCALE("선형배열");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @Builder
    public Question(Long id, Survey survey, String header, String body, Type type, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.survey = survey;
        this.header = header;
        this.body = body;
        this.type = type;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
