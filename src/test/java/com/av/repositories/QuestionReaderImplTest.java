package com.av.repositories;

import com.av.domain.Question;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        QuestionReaderImpl.class
})
@TestPropertySource("classpath:application.properties")
public class QuestionReaderImplTest {

    @Autowired
    QuestionReaderImpl questionReader;

    @Test
    public void getQuestions() {
        List<Question> questions = questionReader.getQuestions();
        Assertions.assertEquals(5, questions.size());
    }
}