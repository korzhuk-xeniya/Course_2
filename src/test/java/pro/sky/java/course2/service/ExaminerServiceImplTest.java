package pro.sky.java.course2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.dto.Question;
import pro.sky.java.course2.exception.NotEnoughtQuestionException;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl underTest;
    private Question question = new Question("What is java?",
            "Java is a programming language");
    private Question question2 = new Question("what is constructor in java?",
            "A constructor in Java is a special method that is used to initialize objects.");
    @Test
    void getQuestions_shouldThrowExceptionWhenAmountBiggerThenSizeOfCollection() {
        when(questionService.getAll()).thenReturn(Collections.emptySet());
        assertThrows(NotEnoughtQuestionException.class, () -> underTest.getQuestions(1));
    }
    @Test
    void getQuestions_shouldReturnCollectionOfUniqueQuestions() {
        int amount = 2;
        Set<Question> questions = Set.of(question, question2);
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(question,question2);

        Collection<Question> result = underTest.getQuestions(amount);

        assertEquals(questions, result);
        assertEquals(amount, result.stream().distinct().count());
    }
}