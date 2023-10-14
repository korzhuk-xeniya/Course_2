package pro.sky.java.course2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.dto.Question;
import pro.sky.java.course2.exception.NotEnoughtQuestionException;
import pro.sky.java.course2.exception.NotFoundQuestionException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question questionElement = new Question(question, answer);
        return add(questionElement);
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotFoundQuestionException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NotEnoughtQuestionException();
        }
        int random = new Random().nextInt(questions.size());
        return (Question) questions.toArray()[random];
    }
}
