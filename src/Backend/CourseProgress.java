/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
 
public class CourseProgress {
    private String courseId;
    private int progress;

    public CourseProgress(String courseId, int progress) {
        this.courseId = courseId;
        this.progress = 0;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
    
    
    
}
