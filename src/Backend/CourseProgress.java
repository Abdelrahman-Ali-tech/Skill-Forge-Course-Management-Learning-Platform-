/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
 
import java.util.ArrayList;

public class CourseProgress {
    private String courseiD;
    private ArrayList<String> progress;

    public CourseProgress(String courseiD) {
        this. courseiD =  courseiD;
        this.progress = new ArrayList<>();
    }

    public String getCourse() {
        return  courseiD;
    }

    public float getProgress() {
        JsonDatabase database=new JsonDatabase();
       Course course= InstructorManagement.findCoursebyId((ArrayList<Course>) database.loadCourses(), this.courseiD);
       float progress=this.progress.size()/course.getLessons().size();
       return progress;
    }
        public ArrayList<String> getlessonsProgress() {

       return progress;
    }
     

    

    public void updateProgress(Lesson lesson,Course course) {
      int index = course.getLessons().indexOf(lesson);
      this.progress.add(String.valueOf(index));
    }
    
    
    
}
