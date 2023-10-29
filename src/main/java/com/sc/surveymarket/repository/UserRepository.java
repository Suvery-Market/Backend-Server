package com.sc.surveymarket.repository;

import com.sc.surveymarket.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
