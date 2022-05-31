package com.av.services;

import com.av.domain.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalcServiceImpl implements CalcService{

    @Value("${passRate}")
    private int passRate;


    public CalcServiceImpl(){}
    private int succeed(Subject subject) {
        return (int) subject.getAnswerList().stream().filter(answer->answer.getAnswer()==answer.getQuestion().getRightAnswer()).count();
    }


    public void printCalc(Subject subject) {
        System.out.println(subject.getSubjectName());
        int succeed = succeed(subject);
        System.out.println(String.format("Количество правильных ответов : %d", succeed));
        System.out.println(succeed>=passRate?"Прошел":"Не прошел");
    }
}
