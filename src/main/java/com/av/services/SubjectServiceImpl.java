package com.av.services;

import com.av.domain.Subject;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class SubjectServiceImpl implements SubjectService {

    public SubjectServiceImpl(){}
    @Override
    public Subject readerSubject() {
        System.out.println("Как тебя зовут: ");
        Scanner in = new Scanner(System.in);
        String subjectName = in.next();
         return new Subject(subjectName);
    }

}
