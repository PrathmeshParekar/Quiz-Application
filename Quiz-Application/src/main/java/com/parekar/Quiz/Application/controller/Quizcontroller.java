package com.parekar.Quiz.Application.controller;

import com.parekar.Quiz.Application.model.Question;
import com.parekar.Quiz.Application.model.QuestionWrapper;
import com.parekar.Quiz.Application.model.Response;
import com.parekar.Quiz.Application.service.Quizservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class Quizcontroller {

    @Autowired
    Quizservice quizservice;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title ) {
        return quizservice.createQuiz(category, numQ, title);
//        quizservice.createQuiz(category, numQ,title)

    }


    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return  quizservice.getQuizQuestions(id);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizservice.CalculateResult(id, response);
    }


}
