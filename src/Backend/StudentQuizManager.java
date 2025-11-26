/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author Khaled
 */
public class StudentQuizManager {
    private JsonDatabase database; 
    private Student student;

    public StudentQuizManager(Student student) {
        this.student = student;
        this.database = new JsonDatabase();
    }
    
    public QuizAttempt submitQuizalter(Lesson lesson, ArrayList<Integer> studentAnswers, Course course) {

        Quiz quiz = lesson.getQuiz();
        int score = 0;

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            if (quiz.getCorrectIndex().get(i) == studentAnswers.get(i))
                score++;
        }

        QuizAttempt attempt = new QuizAttempt(lesson.getLessonId(), score, quiz.getQuestions().size());

        for (CourseProgress cp : student.getEnrolledCourses()) {
            if ((InstructorManagement.findCoursebyId((ArrayList<Course>) database.loadCourses(),cp.getCourse())).getCourseId().equals(course.getCourseId())) {

                cp.addAttempt(attempt);
                
                if (score == quiz.getQuestions().size()) {
                    lesson.setStatue(true);
                }
            }
        }

        ArrayList<User> all = (ArrayList<User>) database.loadUsers();
        all.remove(student);
        all.add(student);
        database.saveUsers(all);

        return attempt;
    }
      public QuizAttempt submitQuiz(Lesson lesson, ArrayList<Integer> studentAnswers, Course course) {

        Quiz quiz = lesson.getQuiz();
        int score = 0;

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            if (quiz.getCorrectIndex().get(i) == studentAnswers.get(i))
                score++;
        }

        QuizAttempt attempt = new QuizAttempt(lesson.getLessonId(), score, quiz.getQuestions().size());
        return attempt;
    }
    
}
