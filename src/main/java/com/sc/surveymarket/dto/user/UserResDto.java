package com.sc.surveymarket.dto.user;

import com.sc.surveymarket.document.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResDto {

    private String id;
    private String nickname;
    private String email;
    private String phoneNumber;

    @Builder
    public UserResDto(String id, String nickname, String email, String phoneNumber) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static UserResDto create(User user) {
        return UserResDto.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
