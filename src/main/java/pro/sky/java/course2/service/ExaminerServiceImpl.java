package pro.sky.java.course2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.dto.Question;
import pro.sky.java.course2.exception.NotEnoughtQuestionException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random = new Random();
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(questionService.getAll().size() < amount) {
            throw new NotEnoughtQuestionException();
        }
        Set<Question> resultQuestions = new HashSet<>();
        while (resultQuestions.size() < amount) {
            resultQuestions.add(questionService.getRandomQuestion());

        }
        return resultQuestions;
    }
}
