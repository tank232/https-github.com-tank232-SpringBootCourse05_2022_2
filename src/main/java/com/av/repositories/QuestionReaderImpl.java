package com.av.repositories;


import com.av.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionReaderImpl implements QuestionReader {
    @Value("${fileName}")
    private String fileName;

    public QuestionReaderImpl(){}


    public List<Question> getQuestions() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            List<Question> questions = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] questionCsv = line.split(",");
                Question question = new Question();
                question.setId(Integer.parseInt(questionCsv[0]));
                question.setQuestion(questionCsv[1]);
                question.setRightAnswer(Short.parseShort(questionCsv[2]));
                question.setAnswers(List.of(questionCsv[3], questionCsv[4], questionCsv[5]));
                questions.add(question);
            }
            return questions;
        } catch (IOException e) {
            System.out.println(String.format("Error in processing file %s: %s", fileName, e));
        }
        return null;
    }
}
