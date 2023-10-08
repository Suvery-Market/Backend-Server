package com.sc.suverymarket.dto.user;

import com.sc.suverymarket.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserReqDto {

    @Data
    @NoArgsConstructor
    public static class UserJoinReqDto {

        @NotEmpty(message = "nickname은 필수입니다.")
        @Size(min = 5, max = 20, message = "nickname은 5~20자 이내로 작성해주세요.")
        private String nickname;

        @NotEmpty(message = "email은 필수입니다.")
        @Email(message = "email 형식에 맞추어 작성해주세요.")
        private String email;

        @NotEmpty(message = "phoneNumber는 필수입니다.")
        @Size(min = 11, max = 11, message = "phoneNumber 형식에 맞추어 작성해주세요.")
        private String phoneNumber;

        @NotEmpty(message = "socialId는 필수입니다.")
        private String socialId;

        public User toEntity() {
            return User.builder()
                    .nickname(nickname)
                    .email(email)
                    .phoneNumber(phoneNumber)
                    .socialId(socialId)
                    .build();
        }

        @Builder
        public UserJoinReqDto(String nickname, String email, String phoneNumber, String socialId) {
            this.nickname = nickname;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.socialId = socialId;
        }
    }

}
