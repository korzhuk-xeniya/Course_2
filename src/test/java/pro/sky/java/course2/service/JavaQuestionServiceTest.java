package pro.sky.java.course2.service;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.dto.Question;
import pro.sky.java.course2.exception.NotEnoughtQuestionException;
import pro.sky.java.course2.exception.NotFoundQuestionException;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService underTest = new JavaQuestionService();
    private Question question = new Question("What is java?",
            "Java is a programming language");
    private Question question2 = new Question("what is constructor in java?",
            "A constructor in Java is a special method that is used to initialize objects.");

    @Test
    void add_shouldAddNewQuestionAndReturnAddedQuestion() {
        Question result = underTest.add(question.getQuestion(), question.getAnswer());

        assertTrue(underTest.getAll().contains(question));
        assertEquals(question, result);
    }

    @Test
    void remove_shouldRemoveQuestionAndReturnRemovedQuestion() {
        underTest.add(question);
        underTest.add(question2);
        Question result = underTest.remove(question);

        assertFalse(underTest.getAll().contains(question));
        assertEquals(question, result);
    }
    @Test
    void remove_shouldThrowExceptionWhenCollectionNotContainsQuestion() {
        assertThrows(NotFoundQuestionException.class, () -> underTest.remove(question));
    }
    @Test
    void getAll_shouldReturnCollectionOfQuestions() {

        underTest.add(question);
        underTest.add(question2);

        Collection<Question> result = underTest.getAll();

        assertEquals(Set.of(question, question2), result);
    }

    @Test
    void getRandomQuestion_shouldThrowExceptionWhenCollectionIsEmpty() {
        assertThrows(NotEnoughtQuestionException.class, () -> underTest.getRandomQuestion());
    }

    @Test
    void getRandomQuestion_shouldReturnRandomQuestionsWhenCollectionIsNotEmpty() {
        underTest.add(question);

        Question result = underTest.getRandomQuestion();

        assertEquals(question, result);
    }
}