package com.sc.suverymarket.repository;

import com.sc.suverymarket.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
