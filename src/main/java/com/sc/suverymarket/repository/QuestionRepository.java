package com.sc.suverymarket.repository;

import com.sc.suverymarket.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
