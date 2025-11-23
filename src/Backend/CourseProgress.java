/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
 
import java.util.ArrayList;

public class CourseProgress {
    private Course course;
    private int progress;
    private ArrayList<QuizAttempt> attempts;
    
    public CourseProgress(Course course) {
        this.course = course;
        this.progress = 0;
    }

    public Course getCourse() {
        return course;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
    

    public void updateProgress(Lesson lesson,Course course) {
        lesson.setStatue(true);
        int numOfCompleteLessons=0;
        int numOfLessons=0;
        for(Lesson l :course.getLessons())
        {numOfLessons+=1;
        if(l.isStatue())
            numOfCompleteLessons+=1;
        }
        this.setProgress(numOfCompleteLessons/numOfLessons);
    }

    public ArrayList<QuizAttempt> getAttempts() {
        return attempts;
    }
    
    
    public void addAttempt(QuizAttempt attempt){
        attempts.add(attempt);
    }
    
    public QuizAttempt getAttemptForLesson(String lessonId){
        for(QuizAttempt a:attempts){
            if(a.getLesssonId().equals(lessonId)) return a;
        }
        return null;
    }
}
