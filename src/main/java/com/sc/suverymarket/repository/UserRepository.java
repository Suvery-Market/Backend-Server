package com.sc.suverymarket.repository;

import com.sc.suverymarket.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
