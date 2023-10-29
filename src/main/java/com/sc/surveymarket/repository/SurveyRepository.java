package com.sc.surveymarket.repository;

import com.sc.surveymarket.document.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepository extends MongoRepository<Survey, String> {
}
