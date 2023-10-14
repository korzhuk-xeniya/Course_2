package pro.sky.java.course2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Недостаточно вопросов")
public class NotEnoughtQuestionException extends RuntimeException {
}
