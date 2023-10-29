package com.sc.suverymarket.repository;

import com.sc.suverymarket.document.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepository extends MongoRepository<Survey, String> {
}
