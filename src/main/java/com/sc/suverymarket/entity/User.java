package com.sc.suverymarket.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 83)
    private String email;

    @Column(nullable = false, length = 13)
    private String phoneNumber;

    @Column(nullable = false)
    private String socialId;

    @CreatedDate // Insert
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Insert or Update
    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    @Builder
    public User(Long id, String nickname, String email, String phoneNumber, String socialId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.socialId = socialId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
