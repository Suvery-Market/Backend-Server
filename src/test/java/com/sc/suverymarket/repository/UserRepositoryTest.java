package com.sc.suverymarket.repository;

import com.sc.suverymarket.dto.user.UserJoinReqDto;
import com.sc.suverymarket.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    
    @Test
    public void 사용자_회원가입() throws Exception {

        String nickname = "사용자-1";
        String email = "사용자-1@gmail.com";
        String phoneNumber = "01012345678";
        String socialId = "registration_1234567890";

        User createdUser = UserJoinReqDto.builder()
                .nickname(nickname)
                .email(email)
                .phoneNumber(phoneNumber)
                .socialId(socialId)
                .build()
                .toEntity();

        User savedUser = userRepository.save(createdUser);

        assertThat(savedUser.getNickname()).isEqualTo(nickname);
        assertThat(savedUser.getEmail()).isEqualTo(email);
        assertThat(savedUser.getPhoneNumber()).isEqualTo(phoneNumber);
        assertThat(savedUser.getSocialId()).isEqualTo(socialId);
    }

}