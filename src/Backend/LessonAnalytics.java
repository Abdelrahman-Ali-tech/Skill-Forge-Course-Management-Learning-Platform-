/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Khaled
 */
public class LessonAnalytics {
    private String lessonTitle;
    private double averageQuizScore; 
    private double completionPercentage; 

    public LessonAnalytics(String lessonTitle, double avgScore, double completion) {
        this.lessonTitle = lessonTitle;
        this.averageQuizScore = avgScore;
        this.completionPercentage = completion;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public double getAverageQuizScore() {
        return averageQuizScore;
    }

    public double getCompletionPercentage() {
        return completionPercentage;
    }

    
}
