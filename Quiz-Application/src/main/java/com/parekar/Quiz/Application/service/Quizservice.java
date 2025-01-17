package com.parekar.Quiz.Application.service;

import com.parekar.Quiz.Application.dao.Quizdao;
import com.parekar.Quiz.Application.dao.QuestionDao;
import com.parekar.Quiz.Application.model.Question;
import com.parekar.Quiz.Application.model.QuestionWrapper;
import com.parekar.Quiz.Application.model.Quiz;
import com.parekar.Quiz.Application.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Quizservice {

    @Autowired
    Quizdao quizdao;

    @Autowired
    QuestionDao questiondao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {


        Quiz quiz = new Quiz();
        List<Question> questions = questiondao.findRandomQuestionByCatogery(category,numQ);

        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizdao.save(quiz);

        return new ResponseEntity("hi", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizdao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> QuestionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            QuestionsForUser.add(qw);
        }

        return new ResponseEntity<>(QuestionsForUser , HttpStatus.OK);

    }


    public ResponseEntity<Integer> CalculateResult(Integer id, List<Response> response) {
        Quiz quiz = quizdao.findById(id).get();
        List<Question> questions= quiz.getQuestions();

        int right = 0;
        int i = 0;

        for(Response responses : response){
            if(responses.getResponse().equals(questions.get(id).getRightAnswer()))

                right++;
            i++;

        }
        return new ResponseEntity<>(i , HttpStatus.OK);
    }
}
