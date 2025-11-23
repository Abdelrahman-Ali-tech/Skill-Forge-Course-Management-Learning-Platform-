/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;


public class Student extends User{

   private ArrayList <CourseProgress> enrolledCourses;


    public Student(  String username, String email, String passwordHash,ArrayList <CourseProgress> enrolledCourses) {
        super(username,email,passwordHash,"student");
        this.role="student";
        this.enrolledCourses=enrolledCourses;
        
    }

    public ArrayList<CourseProgress> getEnrolledCourses() {
        return enrolledCourses;
       
    }

    public void setEnrolledCourses(ArrayList<CourseProgress> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
    public void addCourse(Course course) {
        CourseProgress enrolledCourse= new CourseProgress(course);
        this.enrolledCourses.add(enrolledCourse);
        
    }
    
}
