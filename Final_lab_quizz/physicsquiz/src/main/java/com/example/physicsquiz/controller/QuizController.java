package com.example.physicsquiz.controller;

import com.example.physicsquiz.model.Question;
import com.example.physicsquiz.model.QuizResult;
import com.example.physicsquiz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/start")
    public String showStartPage() {
        return "start";
    }

    @PostMapping("/validate")
    public String validateStudent(@RequestParam String studentId, Model model) {
        if (quizService.validateStudent(studentId)) {
            model.addAttribute("questions", quizService.getQuestions());
            model.addAttribute("studentId", studentId);
            return "quiz";
        } else {
            model.addAttribute("error", "অবৈধ শিক্ষার্থী আইডি। দয়া করে সঠিক আইডি প্রবেশ করান।");
            return "start";
        }
    }

    @PostMapping("/submit")
    public String submitQuiz(
            @RequestParam String studentId,
            @RequestParam List<Integer> answers,
            Model model) {

        int score = quizService.calculateScore(answers);
        quizService.saveResult(studentId, score);

        model.addAttribute("score", score);
        model.addAttribute("total", quizService.getQuestions().size());
        model.addAttribute("studentId", studentId);

        return "result";
    }

    @GetMapping("/results/{studentId}")
    @ResponseBody
    public List<QuizResult> getStudentResults(@PathVariable String studentId) {
        return quizService.getStudentResults(studentId);
    }
}