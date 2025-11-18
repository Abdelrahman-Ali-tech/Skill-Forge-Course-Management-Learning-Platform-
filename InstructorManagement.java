/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;


public class InstructorManagement {
    private ArrayList<Course> createdcCourses;
    private ArrayList<Course> courses;
   private JsonDatabase database;
    private Instructor instructor;

    public InstructorManagement( Instructor instructor) {
        this.createdcCourses = instructor.getCreatedcCourses();
        this.database=new JsonDatabase();
        this.courses=(ArrayList<Course>) database.loadCourses();
        this.instructor = instructor;
    }
    public  void createCourse(String title, String description, Instructor instructor) {
        Course course=new Course(title, description, description);
        instructor.addCourse(course);
        courses.add(course);
        this.database.saveCourses(courses);

    }
    public  ArrayList<Student> viewEnrolledStudents(Course c) {
        return c.getStudents();
        
    }
    
    public void addLesson(Course course,String title, String content, String[] optionalResources)
    {
     course.addLesson(title,content,optionalResources);
    } 
    public  void editLesson(Lesson lesson,String title, String content, String[] optionalResources) {
        lesson.setContent(content);
        lesson.setOptionalResources(optionalResources);
        lesson.setTitle(title);
        
    }
    public void deleteLesson(Course c,Lesson lesson)
    {
    
    
    ArrayList<Lesson> lessons=c.getLessons();
    lessons.remove(lesson);
    c.setLessons(lessons);
    
    }
    
    
}
