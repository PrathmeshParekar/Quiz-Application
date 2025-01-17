package com.parekar.Quiz.Application.dao;

import com.parekar.Quiz.Application.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Quizdao extends JpaRepository<Quiz, Integer> {
//    void save(Quiz quiz);

//    void save(Quiz quiz);
}
