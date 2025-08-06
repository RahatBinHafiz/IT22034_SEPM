package com.example.physicsquiz.service;

import com.example.physicsquiz.model.Question;
import com.example.physicsquiz.model.QuizResult;
import com.example.physicsquiz.model.Student;
import com.example.physicsquiz.repository.QuizResultRepository;
import com.example.physicsquiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizService {
    private final StudentRepository studentRepository;
    private final QuizResultRepository quizResultRepository;

    private final List<Question> questions = Arrays.asList(
            new Question(
                    "১. নিউটনের গতির প্রথম সূত্র কী বলে?",
                    Arrays.asList(
                            "বস্তুর ভরবেগের পরিবর্তনের হার প্রয়োগকৃত বলের সমানুপাতিক",
                            "প্রত্যেক ক্রিয়ারই একটি সমান ও বিপরীত প্রতিক্রিয়া আছে",
                            "বাহ্যিক বল প্রয়োগ না করলে স্থির বস্তু স্থির থাকবে এবং গতিশীল বস্তু সুষম গতিতে সরলরেখায় চলতে থাকবে",
                            "বস্তুর ত্বরণ প্রয়োগকৃত বলের সমানুপাতিক"
                    ),
                    2 // Correct answer index (0-based)
            ),
            new Question(
                    "২. আলোর গতি সবচেয়ে বেশি কোন মাধ্যমে?",
                    Arrays.asList(
                            "জলে",
                            "কাঁচে",
                            "শূন্যস্থানে",
                            "বায়ুতে"
                    ),
                    2 // Correct answer index (0-based)
            )
    );

    public QuizService(StudentRepository studentRepository, QuizResultRepository quizResultRepository) {
        this.studentRepository = studentRepository;
        this.quizResultRepository = quizResultRepository;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public boolean validateStudent(String studentId) {
        return studentRepository.existsByStudentId(studentId);
    }

    public int calculateScore(List<Integer> answers) {
        int score = 0;
        for (int i = 0; i < Math.min(answers.size(), questions.size()); i++) {
            if (answers.get(i) == questions.get(i).getCorrectAnswerIndex()) {
                score++;
            }
        }
        return score;
    }

    public void saveResult(String studentId, int score) {
        QuizResult result = new QuizResult(studentId, score);
        quizResultRepository.save(result);
    }

    public List<QuizResult> getStudentResults(String studentId) {
        return quizResultRepository.findByStudentId(studentId);
    }
}