package com.sc.suverymarket.repository;

import com.sc.suverymarket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
