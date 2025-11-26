 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Khaled
 */
public class QuizAttempt {
    private String LesssonId;
    private int score;
    private int total;

    public QuizAttempt(String LesssonId, int score, int total) {
        this.LesssonId = LesssonId;
        this.score = score;
        this.total = total;
    }

    public String getLesssonId() {
        return LesssonId;
    }

    public int getScore() {
        return score;
    }

    public int getTotal() {
        return total;
    }
    
    public double getPrecentage(){
        return (score/total)*100.0;
    }
}
