package pro.sky.java.course2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.service.QuestionService;
@RestController
@RequestMapping("/java")
public class JavaController {
    private QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }
}
