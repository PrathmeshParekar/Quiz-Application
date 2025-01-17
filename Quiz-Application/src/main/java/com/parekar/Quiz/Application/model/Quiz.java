package com.parekar.Quiz.Application.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue (strategy  = GenerationType.IDENTITY)

    private int id;
    private String title;

    @ManyToMany
    private List<Question> questions;


    public Quiz(){};
    public Quiz (String title, List<Question> questions){
        this.setTitle(title);
        this.setQuestions(questions);
    }

    public Quiz (int id ,String title, List<Question> questions){
        this.setId(id);
        this.setTitle(title);
        this.setQuestions(questions);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public  void setTitle(String title){
        this.title = title;
    }



    public List<Question>  getQuestions(){
        return questions;
    }

    public  void setQuestions(List<Question> questions){
        this.questions = questions;
    }




}
