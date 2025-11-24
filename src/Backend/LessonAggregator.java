/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Khaled
 */
public class LessonAggregator {
    private int totalScore = 0;
    private int totalPossibleScore = 0;
    private int totalCompletions = 0;

    public void addAttempt(int score, int total) {
        this.totalScore += score;
        this.totalPossibleScore += total;
    }
    
    public void addCompletion(int completed) {
        this.totalCompletions += completed;
    }
    
    public int getTotalCompletions() {
        return totalCompletions;
    }

    public double calculateAverageScore() {
        if (totalPossibleScore == 0) return 0.0;
        return ((double) totalScore / (double) totalPossibleScore) * 100.0;
    }
}
