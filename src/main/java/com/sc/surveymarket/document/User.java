package com.sc.surveymarket.document;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Document
@Getter
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 83)
    private String email;

    @Column(nullable = false, length = 13)
    private String phoneNumber;

    @Column(nullable = false)
    private String socialId;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Version
    private Integer version;

    @Builder
    public User(String id, String nickname, String email, String phoneNumber, String socialId) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.socialId = socialId;
    }
}
