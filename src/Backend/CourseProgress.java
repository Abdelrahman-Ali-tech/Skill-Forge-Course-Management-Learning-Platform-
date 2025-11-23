/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
 
public class CourseProgress {
    private Course course;
    private int progress;

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
    
    
    
}
