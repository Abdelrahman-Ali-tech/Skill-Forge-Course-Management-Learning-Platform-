/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Backend.JsonDatabase;
import java.util.ArrayList;

public class StudentManagement {
    private Student student;
    private ArrayList<Course> courses;
    private JsonDatabase database ;
    
    public StudentManagement(Student student) {
        this.student = student;
        database= new JsonDatabase();
        this.courses =(ArrayList<Course>) database.loadCourses() ;
    }
    public ArrayList<Course> browsingCourses ()
    {
    ArrayList<Course> availableCourses=(ArrayList<Course>) courses.clone();
    for(CourseProgress courseProgress : this.student.getEnrolledCourses())
    {

        availableCourses.remove(courseProgress.getCourse());
    }
    return availableCourses;
    
    }
        public ArrayList<Course> enrolledCourses ()
    {
    ArrayList<Course> enrolledCourses=new ArrayList<>();
    for(CourseProgress courseProgress : this.student.getEnrolledCourses())
    {
       
       enrolledCourses.add(courseProgress.getCourse());
    }
    return enrolledCourses;
    
    }
    public  ArrayList<Lesson> viewLessons(String courseId) {
        Course course=findCoursebyId(courses, courseId);
        ArrayList<Lesson> lessons=course.getLessons();
        return lessons;
    }
    
    public void  enroll(String id)
    {  
      
      Course course=findCoursebyId(courses, id);
      student.addCourse(course);
      course.addStudent(student);
      
      
    }
    public Course findCoursebyId(ArrayList<Course> courses,String courseID)
    {
    for (Course c :courses)
    {
    if(c.getCourseId()==courseID)
        return c;
    }
    return null;
    }
    
    
}
