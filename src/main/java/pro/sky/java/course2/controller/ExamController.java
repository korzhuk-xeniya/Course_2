package pro.sky.java.course2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.service.ExaminerService;

import java.util.Collection;

@RestController

public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
