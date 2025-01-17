package com.parekar.Quiz.Application.controller;


import com.parekar.Quiz.Application.model.Question;
import com.parekar.Quiz.Application.service.Questionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("question")
public class Questioncontroller {

    @Autowired
    Questionservice questionservice;

    @GetMapping("allquestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionservice.getAllQuestion();
    }

        @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionservice.getQuestionByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionservice.addQuestion(question);
    }

}
